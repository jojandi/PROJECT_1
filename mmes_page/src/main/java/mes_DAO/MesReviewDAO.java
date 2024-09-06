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

import mes_DTO.MesReviewDTO;

public class MesReviewDAO {
	
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
	
	public List selectReview() {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;
			PreparedStatement ps = null;

			query = " select f.review_seq, f.review_name, t.user_id, f.review_date";
			query += " from bf_review f";
			query += " left outer join bookflix_user b";
			query += " on f.buser_seq = b.buser_seq";
			query += " left outer join tbl_user t";
			query += " on b.user_seq = t.user_seq";

			ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				MesReviewDTO rvdto = new MesReviewDTO();

				int review_seq = rs.getInt("review_seq");
				rvdto.setReview_seq(review_seq);

				String review_name = rs.getString("review_name");
				rvdto.setReview_name(review_name);

				String user_id = rs.getString("user_id");
				rvdto.setUser_id(user_id);

				Date review_date = rs.getDate("review_date");
				rvdto.setReview_date(review_date);
				
				list.add(rvdto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
