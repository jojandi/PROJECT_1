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
	
	 public List<MesMainDTO> getStatisticsByGenre(Integer year, Integer month) {
	        List<MesMainDTO> list = new ArrayList<>();

	        try {
	            // JNDI를 사용해 데이터 소스 가져오기
	            Context ctx = new InitialContext();
	            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	            
	            // 데이터베이스 연결
	            Connection con = dataSource.getConnection();

	            // SQL 쿼리 작성
	            String query = "SELECT d.bom_code, b.bom_name, SUM(d.total_sales) AS total " +
	                    "FROM deliverystatus_total d " +
	                    "JOIN bom b ON d.bom_code = b.bom_code " +
	                    "WHERE TRUNC(d.date_id / 100) = ? AND MOD(d.date_id, 100) = ? " +
	                    "GROUP BY d.bom_code, b.bom_name";
	            // PreparedStatement 객체 생성
	            PreparedStatement ps = con.prepareStatement(query);

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

}
