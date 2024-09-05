package user.dao.best;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dao.join.LoggableStatement;
import user.dto.best.BestDTO;
import user.dto.my.loan.LoanDTO;

public class BestDAO {

	// 상세내역
	public List bsetList() {
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
			query += " book_img, li_book_info, book_loan, book_res, book_loan_seq ";
			query += " FROM book JOIN li_book USING (book_isbn))";
			query += " select * from (SELECT book_name, book_pub, book_author, book_isbn, ";
			query += " SUM(book_loan_seq) AS total_loan_seq, ";
			query += " MAX(CASE WHEN book_loan = 'N'  and book_res = 'N' AND rn = 1 THEN book_code END) AS book_code, ";
			query += " COUNT(CASE WHEN book_loan = 'N' AND book_res = 'N' THEN book_code END) AS count, book_img, li_book_info ";
			query += " FROM RandomBooks b ";
			query += " GROUP BY book_name, book_pub, book_img, li_book_info, book_author, book_isbn ";
			query += " order by total_loan_seq desc) where rownum <= 5 ";

            PreparedStatement ps = new LoggableStatement(con, query);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				BestDTO dto = new BestDTO();
				
				dto.setBook_ISBN(rs.getLong("book_isbn"));
				dto.setBook_img(rs.getString("book_img"));
				dto.setBook_author(rs.getString("book_author"));
				dto.setBook_name(rs.getString("book_name"));
				dto.setBook_pub(rs.getString("book_pub"));
				dto.setCount(rs.getInt("count"));
				dto.setBook_loan_seq(rs.getInt("total_loan_seq"));
				dto.setLi_book_info(rs.getString("li_book_info"));
				dto.setBook_code(rs.getInt("book_code"));
				
				list.add(dto);
				
			}
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
			String query = " insert into user_res(res_id, book_code, user_seq, res_day, res_ing) ";
			query += " values (user_res_seq.nextval, ?, ?, sysdate, 'Y') ";

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
	
	public int resBook_li(LoanDTO dto) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = " update li_book set book_res = 'Y' ";
			query += " where book_code = ? ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, dto.getBook_code());

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
