package user.dao.my;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.join.JoinDTO;

public class MyDAO {
	
	// 회원정보 업데이트
	public int userUpdate(JoinDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
	      
			// SQL 준비
			String query = "update tbl_user ";
			query += " set user_id = ?, ";
			query += " user_pw = ?, ";
			query += " user_name = ?, ";
			query += " user_tel = ?, ";
			query += " user_addr = ?, ";
			query += " user_addr_info = ?, ";
			query += " user_email = ?, ";
			query += " like_id = ? ";
			query += " where user_seq = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_pw());
			ps.setString(3, dto.getUser_name());
			ps.setInt(4, Integer.parseInt(dto.getUser_tel()));
			ps.setString(5, dto.getUser_addr1());
			ps.setString(6, dto.getUser_addr2());
			ps.setString(7, dto.getUser_email());
			ps.setInt(8, dto.getLike_id());
			ps.setInt(9, dto.getUser_seq());
	      
			// SQL 실행
			result = ps.executeUpdate(); // 몇 줄이 업데이트 되었는지 int로 받음
	      
			ps.close();
			con.close();
	            
			}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int delete(JoinDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
	      
			// SQL 준비
			String query = "delete tbl_user ";
			query += " where user_seq = ? ";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, dto.getUser_seq());
	      
			// SQL 실행
			result = ps.executeUpdate(); // 몇 줄이 업데이트 되었는지 int로 받음
	      
			ps.close();
			con.close();
	            
			}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
