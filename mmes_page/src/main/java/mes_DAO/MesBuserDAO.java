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

import mes_DTO.MesBuserDTO;

public class MesBuserDAO {
	
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
	
	public List selectBuser() {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;
			PreparedStatement ps = null;

			query = " select b.buser_seq, u.user_id, u.user_addr, u.user_email, b.buser_date, b.buser_end";
			query += " from bookflix_user b, tbl_user u";
			query += " where b.user_seq = u.user_seq";
			ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				MesBuserDTO BuserDTO = new MesBuserDTO();

				int buser_seq = rs.getInt("buser_seq");
				BuserDTO.setBuser_seq(buser_seq);

				String user_id = rs.getString("user_id");
				BuserDTO.setUser_id(user_id);

				String user_addr = rs.getString("user_addr");
				BuserDTO.setUser_addr(user_addr);
				
				String user_email = rs.getString("user_email");
				BuserDTO.setUser_email(user_email);

				Date buser_date = rs.getDate("buser_date");
				BuserDTO.setBuser_date(buser_date);
				
				Date buser_end = rs.getDate("buser_end");
				BuserDTO.setBuser_end(buser_end);


				list.add(BuserDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
