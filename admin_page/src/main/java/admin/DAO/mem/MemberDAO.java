package admin.DAO.mem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import admin.DTO.mem.MemberDTO;

public class MemberDAO {
	
	// 사용자 전체 조회
	public List userList() {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select * from tbl_user join user_like using(like_id) ";
			query += " order by user_name ";

            PreparedStatement ps = new LoggableStatement(con, query);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				MemberDTO dto = new MemberDTO();
				
				dto.setLike(rs.getString("like_like"));
				dto.setLike_id(rs.getInt("like_id"));
				dto.setUser_addr1(rs.getString("user_addr"));
				dto.setUser_addr2(rs.getString("user_addr_info"));
				dto.setUser_birth(rs.getDate("user_birth"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_pass(rs.getDate("user_pass"));
				dto.setUser_pw(rs.getString("user_pw"));
				dto.setUser_seq(rs.getInt("user_seq"));
				
				String user_sub = rs.getString("user_sub");
				String user_over = rs.getString("user_over");
				String user_admin = rs.getString("user_admin");
				
				String user_tel = rs.getString("user_tel");
				
				String tel1 = user_tel.substring(0, 2);
				String tel2 = user_tel.substring(2, 6);
				String tel3 = user_tel.substring(6, 10);
				
				String tel = "0" + tel1 + "-" + tel2 + "-" + tel3;
				
				dto.setUser_tel(tel);
				
				if("Y".equals(user_sub)) {
					dto.setUser_sub(true);
				} else {
					dto.setUser_sub(false);
				}
				if("Y".equals(user_over)) {
					dto.setUser_over(true);
				} else {
					dto.setUser_over(false);
				}
				if("Y".equals(user_admin)) {
					dto.setUser_admin(true);
				} else {
					dto.setUser_admin(false);
				}

				list.add(dto);
			}
			System.out.println(list);
			ps.close();
			con.close();
			rs.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 사용자 대출 내역
	public MemberDTO userLoan(int user_seq) {
		MemberDTO dto = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select count(*) as loan_seq from user_loan where user_seq = ? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, user_seq);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				dto = new MemberDTO();
				
				dto.setLoan_seq(rs.getInt("loan_seq"));

			}
			ps.close();
			con.close();
			rs.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 사용자 상세목록
	public MemberDTO user(int user_seq) {
		MemberDTO dto = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " SELECT u.user_seq, u.user_name, u.user_birth, u.user_id, u.user_tel, u.user_email, ";
			query += " u.user_addr, u.user_addr_info, lk.like_like, u.user_pass, ";
			query += " COUNT(CASE WHEN loan_return - loan_ex > 0 THEN user_pass END) AS count ";
			query += " FROM tbl_user u left JOIN user_loan ul ON u.user_seq = ul.user_seq ";
			query += " left JOIN user_like lk ON u.like_id = lk.like_id ";
			query += " WHERE u.user_seq = ? ";
			query += " GROUP BY u.user_seq, u.user_name, u.user_birth, u.user_id, u.user_tel, u.user_email,  ";
			query += " u.user_addr, u.user_addr_info, lk.like_like, u.user_pass ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, user_seq);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				dto = new MemberDTO();
				
				dto.setLike(rs.getString("like_like"));
				dto.setUser_addr1(rs.getString("user_addr"));
				dto.setUser_addr2(rs.getString("user_addr_info"));
				dto.setUser_birth(rs.getDate("user_birth"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_seq(rs.getInt("user_seq"));
				dto.setOver_count(rs.getInt("count"));
				dto.setUser_pass(rs.getDate("user_pass"));
				
				String user_tel = "0";
				user_tel += rs.getString("user_tel");
				
				String tel1 = user_tel.substring(0, 3);
				String tel2 = user_tel.substring(3, 7);
				String tel3 = user_tel.substring(7, 11);
				
				String tel = tel1 + "-" + tel2 + "-" + tel3;
				
				dto.setUser_tel(tel);
				

			}
			System.out.println(dto);
			ps.close();
			con.close();
			rs.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
