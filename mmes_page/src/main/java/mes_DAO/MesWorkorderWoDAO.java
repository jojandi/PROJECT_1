package mes_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mes_DTO.MesNoticeDTO;
import mes_DTO.MesWorkorderWoDTO;

public class MesWorkorderWoDAO {

	private Connection getConnection() {

		Connection con = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
		String user = "scott2_4";
		String password = "tiger";

		try {

			// Class.forName : String을 이용해서 class를 생성한다
			// driver : 서로 다른 것들 (java, oracle)이 소통할 수 있게 도와줌
			// 오라클 드라이버 로딩
			Class.forName(driver);

			// DB 접속
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public List selectWorkwo() {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;
			PreparedStatement ps = null;

			query = " select w.wo_id, b.bom_code, b.bom_name, w.wo_process, wo_count, wo_status";
			query += " from workorder w, bom b";
			query += " where w.bom_code = b.bom_code";
			query += " order by wo_id desc";

			ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				MesWorkorderWoDTO WoDTO = new MesWorkorderWoDTO();

				int wo_id = rs.getInt("wo_id");
				WoDTO.setWo_id(wo_id);

				int bom_code = rs.getInt("bom_code");
				WoDTO.setBom_code(bom_code);

				String bom_name = rs.getString("bom_name");
				WoDTO.setBom_name(bom_name);

				String wo_process = rs.getString("wo_process");
				WoDTO.setWo_process(wo_process);

				
				int wo_count = rs.getInt("wo_count");
				WoDTO.setWo_count(wo_count);

				String wo_status = rs.getString("wo_status");
				WoDTO.setWo_status(wo_status);

				list.add(WoDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public int insert(MesWorkorderWoDTO WoDTO) {

		int result = -1;

		try {

			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = " INSERT INTO workorder (wo_id, bom_code, wo_process, wo_count, wo_status)";
			query += " VALUES (wo_seq.NEXTVAL, ?, ?, ?, '진행중')";

			// PreparedStatement ps = con.prepareStatement(query);
			// 원래 실행되는 걸 LoggableStatement가 가로채서
			PreparedStatement ps = new LoggableStatement(con, query);

			ps.setInt(1, WoDTO.getBom_code());
			
			ps.setString(2, WoDTO.getWo_process());
			
			ps.setInt(3, WoDTO.getWo_count());
			
			// 실제 실행되는 sql을 출력해볼 수 있다
			System.out.println(((LoggableStatement) ps).getQueryString());

			// SQL 실행
			result = ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// bom_code 셀렉트로 보여주는 메소드
		public List getMesbom_code() {
			List mesbom_code = new ArrayList();

			try {
				Context ctx = new InitialContext();
				DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
				Connection con = dataSource.getConnection();

				String query = "SELECT bom_code FROM bom";

				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					mesbom_code.add(rs.getString("bom_code"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return mesbom_code;
		}
		
		public int delete(MesWorkorderWoDTO WoDTO) {

		      int result = -1;

		      try {

		         // Servers 폴더의 context.xml에서
		         // name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기
		         Context ctx = new InitialContext();
		         DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
		         // DB접속 : 커넥션풀을 사용해서
		         Connection con = dataFactory.getConnection();

		         // SQL 준비
		         String query = "delete from workorder where wo_id = ?";
		               
		         

		         PreparedStatement ps = new LoggableStatement(con, query);
		         
		         ps.setInt(1, WoDTO.getWo_id());
		         


		         // 실제 실행되는 sql을 출력해볼 수 있다
		         System.out.println(((LoggableStatement) ps).getQueryString());

		         // SQL 실행
		         result = ps.executeUpdate();

		         ps.close();
		         con.close();

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      return result;
		   }
		
		    public int update(MesWorkorderWoDTO WoDTO) {

		      int result = -1;

		      try {

		         // Servers 폴더의 context.xml에서
		         // name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기
		         Context ctx = new InitialContext();
		         DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
		         // DB접속 : 커넥션풀을 사용해서
		         Connection con = dataFactory.getConnection();

		         // SQL 준비
		         String query = "UPDATE product";
		               query += " SET pd_count = pd_count + ?";
		               query += " WHERE bom_code = ?";
		               
		         

		         PreparedStatement ps = new LoggableStatement(con, query);
		         
		         ps.setLong(1, WoDTO.getWo_count());
		         ps.setLong(2, WoDTO.getBom_code());
		         


		         // 실제 실행되는 sql을 출력해볼 수 있다
		         System.out.println(((LoggableStatement) ps).getQueryString());

		         // SQL 실행
		         result = ps.executeUpdate();

		         ps.close();
		         con.close();

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      return result;
		   }

}
