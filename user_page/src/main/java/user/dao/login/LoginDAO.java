package user.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dao.join.LoggableStatement;
import user.dto.join.JoinDTO;

public class LoginDAO {
	// 사용자 로그인
	public JoinDTO login(JoinDTO dto) {
		JoinDTO result = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select * from tbl_user join user_like using(like_id) ";
			query += " where user_id = ? and user_pw = ? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            
            ps.setString(1, dto.getUser_id());
            ps.setString(2, dto.getUser_pw());
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				result = new JoinDTO();
								
				result.setLike(rs.getString("like_like"));
				result.setLike_id(rs.getInt("like_id"));
				result.setUser_addr1(rs.getString("user_addr"));
				result.setUser_addr2(rs.getString("user_addr_info"));
				result.setUser_birth(rs.getDate("user_birth"));
				result.setUser_email(rs.getString("user_email"));
				result.setUser_id(rs.getString("user_id"));
				result.setUser_name(rs.getString("user_name"));
				result.setUser_pass(rs.getDate("user_pass"));
				result.setUser_pw(rs.getString("user_pw"));
				result.setUser_seq(rs.getInt("user_seq"));
				result.setUser_loan(rs.getInt("user_loan"));
				
				String user_sub = rs.getString("user_sub");
				String user_over = rs.getString("user_over");
				String user_admin = rs.getString("user_admin");
				
				String user_tel = rs.getString("user_tel");
				System.out.println(user_tel);
				
				String tel1 = user_tel.substring(0, 2);
				String tel2 = user_tel.substring(2, 6);
				String tel3 = user_tel.substring(6, 10);
				
				String tel = "0" + tel1 + "-" + tel2 + "-" + tel3;
				
				result.setUser_tel(tel);
				
				if("Y".equals(user_sub)) {
					result.setUser_sub(true);
				} else {
					result.setUser_sub(false);
				}
				if("Y".equals(user_over)) {
					result.setUser_over(true);
				} else {
					result.setUser_over(false);
				}
				if("Y".equals(user_admin)) {
					result.setUser_admin(true);
				} else {
					result.setUser_admin(false);
				}
				
				System.out.println("result : " + result);
				
			}
			
			rs.close();
			ps.close();
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
