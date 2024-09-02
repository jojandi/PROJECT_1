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
import mes_DTO.MesPfworkDTO;

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

			String query = null;

			query = " select o.os_id, b.bom_name, t.user_id, o.os_date, e.emp_name";
			query += " from orderstatus o";
			query += " join bom b on o.bom_code = b.bom_code";
			query += " join bookflix_user f on o.buser_seq = f.buser_seq";
			query += " join employee e on o.emp_id = e.emp_id";
			query += " join tbl_user t on f.user_seq = t.user_seq";
			query += " order by os_id desc";
			
			PreparedStatement ps = new LoggableStatement(con, query);
			
			System.out.println(((LoggableStatement) ps).getQueryString());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MesPfworkDTO PfworkDTO = new MesPfworkDTO();

				int os_id = rs.getInt("os_id");
				PfworkDTO.setOs_id(os_id);

				String bom_name = rs.getString("bom_name");
				PfworkDTO.setBom_name(bom_name);
				System.out.println(bom_name);

				String user_id = rs.getString("user_id");
				PfworkDTO.setUser_id(user_id);

				Date os_date = rs.getDate("os_date");
				PfworkDTO.setOs_date(os_date);
				
				String emp_name = rs.getString("emp_name");
				PfworkDTO.setEmp_name(emp_name);

				list.add(PfworkDTO);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public int insert(MesPfworkDTO PfworkDTO) {

		int result = -1;

		try {

			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = " INSERT INTO orderstatus (os_id, bom_code, emp_id, os_date, buser_seq)";
			query += " VALUES (os_seq.NEXTVAL, ?, ?, ?, ?)";
			PreparedStatement ps = new LoggableStatement(con, query);

			ps.setInt(1, PfworkDTO.getBom_code());

			ps.setInt(2, PfworkDTO.getEmp_id());
			
			ps.setDate(3, PfworkDTO.getOs_date());
			
			ps.setInt(4, PfworkDTO.getBuser_seq());

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
	
	// emp_id를 리스트로 반환하는 메서드
    public List<String> getMesPubId() {
        List<String> mesEmp_id = new ArrayList<>();
        
        try {
           Context ctx = new InitialContext();
         DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
         Connection con = dataSource.getConnection();
         
         String query = "SELECT emp_id FROM employee";
         
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery();
         
            while (rs.next()) {
            	mesEmp_id.add(rs.getString("emp_id"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mesEmp_id;
    }
    
    // bom_code를 리스트로 반환하는 메서드
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
    
    // buser_seq를 리스트로 반환하는 메서드
    public List<String> getMesbuser_seq() {
    	List<String> mesbuser_seq = new ArrayList<>();
    	
    	try {
    		Context ctx = new InitialContext();
    		DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
    		Connection con = dataSource.getConnection();
    		
    		String query = "SELECT buser_seq FROM bookflix_user";
    		
    		PreparedStatement ps = con.prepareStatement(query);
    		ResultSet rs = ps.executeQuery();
    		
    		while (rs.next()) {
    			mesbuser_seq.add(rs.getString("buser_seq"));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return mesbuser_seq;
    }
    
    public List selectpfworkds() {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;

			query = " select o.os_id, d.ds_date, t.user_id, b.bom_name, d.ds_con";
			query += " from deliverystatus d";
			query += " left outer join orderstatus o";
			query += " on d.os_id = o.os_id";
			query += " left outer join bookflix_user f";
			query += " on o.buser_seq = f.buser_seq";
			query += " left outer join tbl_user t";
			query += " on t.user_seq = f.user_seq";
			query += " left outer join bom b";
			query += " on b.bom_code = o.bom_code";
			
			PreparedStatement ps = new LoggableStatement(con, query);
			
			System.out.println(((LoggableStatement) ps).getQueryString());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MesPfworkDTO PfworkDTO = new MesPfworkDTO();

				int os_id = rs.getInt("os_id");
				PfworkDTO.setOs_id(os_id);
				
				Date ds_date = rs.getDate("ds_date");
				PfworkDTO.setDs_date(ds_date);
				
				String user_id = rs.getString("user_id");
				PfworkDTO.setUser_id(user_id);

				String bom_name = rs.getString("bom_name");
				PfworkDTO.setBom_name(bom_name);

				String ds_con = rs.getString("ds_con");
				PfworkDTO.setDs_con(ds_con);

				list.add(PfworkDTO);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
