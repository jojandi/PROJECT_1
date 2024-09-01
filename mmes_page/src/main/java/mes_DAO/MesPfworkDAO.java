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

public class MesPfworkDAO {
	
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
	
	public List selectpfwork() {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = "";
			PreparedStatement ps = null;

			query = " select o.os_id, b.bom_code, f.buser_seq, o.os_date, e.emp_name";
			query += " from orderstatus o";
			query += " join bom b on o.bom_code = b.bom_code";
			query += " join bookflix_user f on o.buser_seq = f.buser_seq";
			query += " join employee e on o.emp_id = e.emp_id";
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

				list.add(NoticeDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
