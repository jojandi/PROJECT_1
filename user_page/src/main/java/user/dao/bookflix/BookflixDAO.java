package user.dao.bookflix;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dao.join.LoggableStatement;
import user.dto.bookflix.BookflixDTO;


public class BookflixDAO {
	
	
	public List userBookflix(int seq) {
		List list = new ArrayList();

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;

			query = " select b.mes_book_code1, b.mes_book_code2, b.mes_book_code3, u.like_id, u.user_seq, ";
			query += " u.user_name, b.bom_name, bk.book_name, bk.book_img, li.li_book_info, bu.buser_seq, ";
			query += " bu.buser_date, bu.buser_end, bk.book_pub, bk.book_author from bom b  ";
			query += " left join tbl_user u on (b.bom_code = (u.like_id+1000)) ";
			query += " left join mes_book m on (m.mes_book_code = b.mes_book_code1 or m.mes_book_code = b.mes_book_code2 or m.mes_book_code = b.mes_book_code3) ";
			query += " left join book bk on (m.book_isbn = bk.book_isbn) ";
			query += " left join li_book li on (bk.book_isbn = li.book_isbn) ";
			query += " left join bookflix_user bu on (u.user_seq = bu.user_seq) ";
			query += " where u.user_seq=?";
			query += " group by b.mes_book_code1, b.mes_book_code2, b.mes_book_code3, u.like_id, u.user_seq, ";
			query += " u.user_name, b.bom_name, bk.book_name, bk.book_img, li.li_book_info, bk.book_pub, ";
			query += " bk.book_author, bu.buser_date, bu.buser_end, bu.buser_seq ";

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
				dto.setBuser_date(rs.getDate("buser_date"));
				dto.setBuser_end(rs.getDate("buser_end"));
				dto.setBuser_seq(rs.getInt("buser_seq"));
				dto.setUser_seq(rs.getInt("user_seq"));
				
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	// 리뷰 인서트
	public int bookflixReview(int user, int buser, int star, String text) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;

			query = " insert into bf_review (review_seq, buser_seq, review_name, review_contents, review_date, review_score) ";
			query += " values ";
			query += " (review_seq.nextval, ?, ";
			query += " (select bom_name from bom b ";
			query += " left join tbl_user u on (b.bom_code = (u.like_id+1000)) ";
			query += " where u.user_seq=?)||' 후기', ";
			query += " ?, sysdate, ?) ";


			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, buser);
			ps.setInt(2, user);
			ps.setString(3, text);
			ps.setInt(4, star);

			System.out.println(((LoggableStatement) ps).getQueryString());

			result = ps.executeUpdate(); 


		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// 북플릭스 가입
	public int bookflixSub(int user) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;

			query = " update tbl_user set user_sub = 'Y' where user_seq=? ";


			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, user);

			System.out.println(((LoggableStatement) ps).getQueryString());

			result = ps.executeUpdate(); 


		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 북플릭스 유저 인서트
	public int bookflixSubInsert(int user) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;

			query = " insert into bookflix_user (buser_seq, user_seq, buser_date, buser_end) ";
			query += " values (buser_seq.nextval, ?, sysdate, add_months(sysdate, +1)) ";


			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, user);

			System.out.println(((LoggableStatement) ps).getQueryString());

			result = ps.executeUpdate(); 


		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// 북플릭스 유저 탈퇴
	public int bookflixDel(int buser) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;

			query = " delete bookflix_user where buser_seq=? ";


			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, buser);

			System.out.println(((LoggableStatement) ps).getQueryString());

			result = ps.executeUpdate(); 


		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// 북플릭스 탈퇴
	public int bookflixOut(int user) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			Connection con = dateSource.getConnection();

			String query = null;

			query = " update tbl_user set user_sub = 'N' where user_seq=? ";


			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, user);

			System.out.println(((LoggableStatement) ps).getQueryString());

			result = ps.executeUpdate(); 


		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
