package user.dao.my;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dao.join.LoggableStatement;
import user.dto.bookflix.BookflixDTO;
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

	// 회원 탈퇴
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
	
	// 북플릭스
	public List userBookflix(int seq) {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;

			query = " select b.mes_book_code1, b.mes_book_code2, b.mes_book_code3, u.like_id, u.user_seq, u.user_name, b.bom_name, bk.book_name, bk.book_img, li.li_book_info ";
			query += " , bk.book_pub, bk.book_author from bom b  ";
			query += " left join tbl_user u on (b.bom_code = (u.like_id+1000)) ";
			query += " left join mes_book m on (m.mes_book_code = b.mes_book_code1 or m.mes_book_code = b.mes_book_code2 or m.mes_book_code = b.mes_book_code3) ";
			query += " left join book bk on (m.book_isbn = bk.book_isbn) ";
			query += " left join li_book li on (bk.book_isbn = li.book_isbn) ";
			query += " where u.user_seq=?";
			query += " group by b.mes_book_code1, b.mes_book_code2, b.mes_book_code3, u.like_id, u.user_seq, u.user_name, b.bom_name, bk.book_name, bk.book_img, li.li_book_info, bk.book_pub, bk.book_author ";

			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, seq);

			System.out.println(((LoggableStatement) ps).getQueryString());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BookflixDTO dto = new BookflixDTO();
				
				dto.setBook_name(rs.getString("book_name"));
				dto.setBook_img(rs.getString("book_img"));
				dto.setBom_name(rs.getString("bom_name"));
				dto.setLike_id(rs.getInt("like_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setBook_pub(rs.getString("book_pub"));
				dto.setBook_author(("book_author"));
				dto.setLi_book_info(rs.getString("li_book_info"));
				
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
}
