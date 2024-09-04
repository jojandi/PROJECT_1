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

			query = " select w.wo_id, b.bom_code, b.bom_name, w.wo_process, wo_sdate, wo_edate, wo_count, wo_status";
			query += " from workorder w, bom b";
			query += " where w.bom_code = b.bom_code";
			
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

				Date wo_sdate = rs.getDate("wo_sdate");
				WoDTO.setWo_sdate(wo_sdate);
				
				Date wo_edate = rs.getDate("wo_edate");
				WoDTO.setWo_edate(wo_edate);
				
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

}
