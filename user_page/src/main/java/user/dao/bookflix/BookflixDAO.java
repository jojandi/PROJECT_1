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

			query = " select b.mes_book_code1, b.mes_book_code2, b.mes_book_code3, u.like_id, u.user_seq, u.user_name, b.bom_name, bk.book_name, bk.book_img, li.li_book_info ";
			query += " , bk.book_pub, bk.book_author from bom b  ";
			query += " join tbl_user u on (b.bom_code = (u.like_id+1000)) ";
			query += " join mes_book m on (m.mes_book_code = b.mes_book_code1 or m.mes_book_code = b.mes_book_code2 or m.mes_book_code = b.mes_book_code3) ";
			query += " join book bk on (m.book_isbn = bk.book_isbn) ";
			query += " join li_book li on (bk.book_isbn = li.book_isbn) ";
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
