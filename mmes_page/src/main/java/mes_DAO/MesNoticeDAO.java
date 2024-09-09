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

public class MesNoticeDAO {

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


	public List selectNotice() {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = "";
			PreparedStatement ps = null;

			query = " select n.notice_id, n.notice_name, e.emp_name, n.notice_date";
			query += " from notice n";
			query += " left outer join employee e";
			query += " on (n.emp_id = e.emp_id)";
			ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				MesNoticeDTO NoticeDTO = new MesNoticeDTO();

				int notice_id = rs.getInt("notice_id");
				NoticeDTO.setNotice_id(notice_id);

				String notice_name = rs.getString("notice_name");
				NoticeDTO.setNotice_name(notice_name);

				String emp_name = rs.getString("emp_name");
				NoticeDTO.setEmp_name(emp_name);

				Date notice_date = rs.getDate("notice_date");
				NoticeDTO.setNotice_date(notice_date);

//				String notice_contents = rs.getString("notice_contents");
//				NoticeDTO.setNotice_contents(notice_contents);

				list.add(NoticeDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public MesNoticeDTO selectOne(int Notice_id) {

		MesNoticeDTO NoticeDTO = null;

		Connection con = getConnection();

		// 접속이 안되었다면 null을 바로 리턴
		if (con == null)
			return null;

		try {

			// sql 준비
			String query = " select * from notice join employee using(emp_id)";
			query += "where notice_id = ?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, Notice_id);

			// sql 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				NoticeDTO = new MesNoticeDTO();
				
				NoticeDTO.setNotice_id( rs.getInt("notice_id") );
				NoticeDTO.setNotice_name( rs.getString("notice_name") );
				NoticeDTO.setEmp_name( rs.getString("emp_name") );
				NoticeDTO.setNotice_date( rs.getDate("notice_date") );
				NoticeDTO.setNotice_contents( rs.getString("notice_contents") );
				
			}
			System.out.println(NoticeDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return NoticeDTO;

	}
	
	public int insert(MesNoticeDTO NoticeDTO) {

		int result = -1;

		try {

			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = " INSERT INTO NOTICE (notice_id, notice_name, notice_contents, notice_date, emp_id)";
			query += " VALUES (notice_seq.NEXTVAL, ?, ?, sysdate, 6)";

			// PreparedStatement ps = con.prepareStatement(query);
			// 원래 실행되는 걸 LoggableStatement가 가로채서
			PreparedStatement ps = new LoggableStatement(con, query);

			ps.setString(1, NoticeDTO.getNotice_name());

			ps.setString(2, NoticeDTO.getNotice_contents());

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
	
	public int update (MesNoticeDTO NoticeDTO) {
		
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			String query = " update notice";
					query += " set notice_name = ?, notice_contents = ?";
					query += " where notice_id = ?";
					
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString( 1, NoticeDTO.getNotice_name() );
			ps.setString( 2, NoticeDTO.getNotice_contents() );
			ps.setInt( 3, NoticeDTO.getNotice_id() );
			
			result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int delete(MesNoticeDTO NoticeDTO) {
		int result = -1;
		
		try {
			
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = " delete notice where notice_id = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt( 1, NoticeDTO.getNotice_id() );
			
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
