package mes_DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import mes_DTO.MesMainDTO;


public class MesMainDAO {
	public List<MesMainDTO> selectAll() {
		List<MesMainDTO> list = new ArrayList<MesMainDTO>();
		
		try {
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
		
			String query = " SELECT * from deliverystatus_total";
				  
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
			
				
				int ds_id = rs.getInt("ds_id");
				int bom_code = rs.getInt("bom_code");
				int total_sales = rs.getInt("total_sales");
				int date_id = rs.getInt("date_id");
				
				MesMainDTO dto = new MesMainDTO();
				dto.setDs_id(ds_id);
				dto.setBom_code(bom_code);
				dto.setTotal_sales(total_sales);
				dto.setDate_id(date_id);
				
				
				
				list.add(dto);
				
				
					
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	// 출고 통계 (장르별 출고량)
	 public List<MesMainDTO> getStatisticsByGenre(Integer year, Integer month) {
	        List<MesMainDTO> list = new ArrayList<>();

	        try {
	            // JNDI를 사용해 데이터 소스 가져오기
	            Context ctx = new InitialContext();
	            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	            
	            // 데이터베이스 연결
	            Connection con = dataSource.getConnection();

	            // SQL 쿼리 작성
	            String qq = "SELECT d.bom_code, b.bom_name, SUM(d.total_sales) AS total " +
	                    "FROM deliverystatus_total d " +
	                    "JOIN bom b ON d.bom_code = b.bom_code " +
	                    "WHERE TRUNC(d.date_id / 100) = ? AND MOD(d.date_id, 100) = ? " +
	                    "GROUP BY d.bom_code, b.bom_name " +
	                    "ORDER BY d.bom_code";  // bom_code를 기준으로 정렬
	            // PreparedStatement 객체 생성
	            PreparedStatement ps = con.prepareStatement(qq);

	            // 연도와 월을 SQL 쿼리에 바인딩
	            ps.setInt(1, year);
	            ps.setInt(2, month);

	            // 쿼리 실행
	            ResultSet rs = ps.executeQuery();
	            

	            // 결과 처리
	            while (rs.next()) {
	                // ResultSet에서 데이터 가져오기
	                int bomCode = rs.getInt("bom_code");
	                String bomName = rs.getString("bom_name");
	                int totalSales = rs.getInt("total");
	               

	                // DTO 객체 생성 및 데이터 설정
	                MesMainDTO dto = new MesMainDTO();
	                dto.setBom_code(bomCode);
	                dto.setGenre(bomName);  // 장르(bom_name) 설정
	                dto.setTotal(totalSales);

	                // 리스트에 DTO 추가
	                list.add(dto);
	            }

	            // 리소스 정리
	            rs.close();
	            ps.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	 // 수요 통계 (장르별 수요량)
	 public List<MesMainDTO> getStatisticsByGenreForDemand(int hihi, int byebye) {
	        List<MesMainDTO> list = new ArrayList<>();
	        try {
	            Context ctx = new InitialContext();
	            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	            Connection con = dataSource.getConnection();

	            // 쿼리 실행 전 로그 남기기
	            System.out.println("DAO - Year: " + hihi + ", Month: " + byebye);

	            String query = "SELECT t.bom_code, b.bom_name, SUM(d.month_dm) AS demand " +
	                    "FROM demand d " +
	                    "JOIN deliverystatus_total t ON d.ds_id = t.ds_id " +
	                    "JOIN bom b ON t.bom_code = b.bom_code " +
	                    "WHERE FLOOR(t.date_id / 100) = ?  " +  // 연도 추출
	                    "AND MOD(t.date_id, 100) = ? " +         // 월 추출
	                    "GROUP BY t.bom_code, b.bom_name " +     // 공백 추가
	                    "ORDER BY t.bom_code";   


	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, hihi);
	            ps.setInt(2, byebye);

	            ResultSet rs = ps.executeQuery();

	            if (!rs.isBeforeFirst()) {
	                System.out.println("DAO - No data found for the query.");
	            }

	            while (rs.next()) {
	                int bomCode = rs.getInt("bom_code");
	                String bomName = rs.getString("bom_name");
	                int demand = rs.getInt("demand");

	                MesMainDTO dto = new MesMainDTO();
	                dto.setBom_code(bomCode);
	                dto.setGenre(bomName);
	                dto.setDemand(demand);

	                list.add(dto);
	            }

	            rs.close();
	            ps.close();
	            con.close();
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	 public List<MesMainDTO> getForecastStatisticsByGenre(int year, int month) {
		    List<MesMainDTO> forecastList = new ArrayList<>();
		    try {
		        Context ctx = new InitialContext();
		        DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
		        Connection con = dataSource.getConnection();

		        String query = "SELECT b.bom_code, b.bom_name AS genre, SUM(df.expected_demand)*0.13 AS expected_demand " +
		                       "FROM demand_forecast df " +
		                       "JOIN demand d ON df.dm_id = d.dm_id " +
		                       "JOIN deliverystatus_total dt ON d.ds_id = dt.ds_id " +
		                       "JOIN bom b ON dt.bom_code = b.bom_code " +
		                       "WHERE FLOOR(df.forecast_date / 100) = ? AND MOD(df.forecast_date, 100) = ? " +
		                       "GROUP BY b.bom_code, b.bom_name " +  // 장르별로 그룹화
		                       "ORDER BY b.bom_code";

		        PreparedStatement ps = con.prepareStatement(query);
		        ps.setInt(1, year);  // 연도
		        ps.setInt(2, month);  // 월

		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            MesMainDTO dto = new MesMainDTO();
		            dto.setBom_code(rs.getInt("bom_code"));
		            dto.setGenre(rs.getString("genre"));
		            dto.setExpectedDemand(rs.getDouble("expected_demand"));
		            forecastList.add(dto);
		        }

		        rs.close();
		        ps.close();
		        con.close();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return forecastList;
		}


}