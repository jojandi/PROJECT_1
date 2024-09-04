package user.dao.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.my.loan.LoanDTO;
import user.dto.search.SearchDTO;

public class SearchDAO {
	
	// 도서검색
	public List bookSearch(String book_name) {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " WITH RandomBooks AS ( ";
			query += " SELECT book_name, book_pub, book_author, book_isbn, book_code, ";
			query += " ROW_NUMBER() OVER (PARTITION BY book_name ORDER BY DBMS_RANDOM.RANDOM) AS rn, "; 
			query += " book_img, li_book_info, book_loan FROM book";
			query += " JOIN li_book USING (book_isbn) ";
			query += " WHERE lower(book_name) LIKE lower('%'||?||'%') AND book_loan = 'N') ";
			query += " SELECT book_name, book_pub, book_author, book_isbn, ";
			query += " (SELECT book_code FROM RandomBooks rb WHERE rb.book_name = b.book_name AND rn = 1) AS book_code, ";
			query += " COUNT(*) AS count, book_img, li_book_info ";
			query += " FROM RandomBooks b ";
			query += " GROUP BY book_name, book_pub, book_img, li_book_info, book_author, book_isbn ";
			query += " HAVING lower(book_name) LIKE lower('%'||?||'%') ";
			
			
            PreparedStatement ps = new LoggableStatement(con, query);
            
            ps.setString(1, book_name);
            ps.setString(2, book_name);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				SearchDTO dto = new SearchDTO();
								
				dto.setBook_name(rs.getString("book_name"));
				dto.setBook_pub(rs.getString("book_pub"));
				dto.setBook_img(rs.getString("book_img"));
				dto.setLi_book_info(rs.getString("li_book_info"));
				dto.setBook_author(rs.getString("book_author"));
				dto.setBook_ISBN(rs.getLong("book_isbn"));
				dto.setBook_code(rs.getInt("book_code"));
				dto.setCount(rs.getInt("count"));
				
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
	
	// 도서 예약
	public int resBook(LoanDTO dto) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = " insert into user_res(res_id, book_code, user_seq, res_day) ";
			query += " values (user_res_seq.nextval, ?, ?, sysdate) ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, dto.getBook_code());
			ps.setInt(2, dto.getUser_seq());

			// SQL 실행
			result = ps.executeUpdate(); // 몇 줄이 업데이트 되었는지 int로 받음

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// 도서 장바구니
	public int cartBook(LoanDTO dto) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = " insert into user_cart(cart_seq, book_code, user_seq) ";
			query += " values (user_cart_seq.nextval, ?, ?) ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, dto.getBook_code());
			ps.setInt(2, dto.getUser_seq());

			// SQL 실행
			result = ps.executeUpdate(); // 몇 줄이 업데이트 되었는지 int로 받음

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
