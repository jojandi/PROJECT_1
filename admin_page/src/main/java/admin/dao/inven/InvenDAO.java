package admin.DAO.inven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import admin.DTO.inven.InvenDTO;

public class InvenDAO {
	
	// 재고조회 검색
	public List bookList(int start, int end, String book_name) {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			String query= null;
			PreparedStatement ps = null;
			if(book_name == "") {
				query =  " select * from( ";
				query +=  "  select rownum as rnum, book_code, li_book_info, book_isbn, book_img, book_author, book_name, book_pub, book_loan, book_res ";
				query +=  " from ( select * from book join li_book using (book_isbn) ";
				query += " order by to_number(book_code) ) ";
				query += " ) where rnum >=? and rnum <= ? ";
				ps = new LoggableStatement(con, query); // 컴파일
				ps.setInt(1, start);
				ps.setInt(2, end);
				System.out.println("모든것 실행!");
			}
			else if(book_name != null) {
				query =  " select * from( ";
				query +=  "  select rownum as rnum, book_code, li_book_info, book_isbn, book_img, book_author, book_name, book_pub, book_loan, book_res ";
				query +=  " from ( select * from book join li_book using (book_isbn) ";
				query +=  " where lower(book_name) like lower('%'||?||'%') ";
				query += " order by to_number(book_code) ) ";
				query += " ) where rnum >=? and rnum <= ? ";
				ps = new LoggableStatement(con, query);
				ps.setString(1, book_name);
	            ps.setInt(2, start);
				ps.setInt(3, end);
				System.out.println("실행!");
				
			} else {
				query =  " select * from( ";
				query +=  "  select rownum as rnum, book_code, li_book_info, book_isbn, book_img, book_author, book_name, book_pub, book_loan, book_res ";
				query +=  " from ( select * from book join li_book using (book_isbn) ";
				query += " order by to_number(book_code) ) ";
				query += " ) where rnum >=? and rnum <= ? ";
				ps  = new LoggableStatement(con, query); // 컴파일
				ps.setInt(1, start);
				ps.setInt(2, end);
				System.out.println("모든것 실행!");
			}
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				InvenDTO dto = new InvenDTO();
								
				dto.setBook_code(rs.getInt("book_code"));
				dto.setLi_book_info(rs.getString("li_book_info"));
				dto.setBook_ISBN(rs.getLong("book_isbn"));
				dto.setBook_img(rs.getString("book_img"));
				dto.setBook_author(rs.getString("book_author"));
				dto.setBook_name(rs.getString("book_name"));
				dto.setBook_pub(rs.getString("book_pub"));
				
				String book_loan = rs.getString("book_loan");
				String book_res = rs.getString("book_res");
				
				if("Y".equals(book_loan)) {
					dto.setBook_loan(true);
				} else {
					dto.setBook_loan(false);
				}
				if("Y".equals(book_res)) {
					dto.setBook_res(true);
				} else {
					dto.setBook_res(false);
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
	
	
	// 전체 페이지
	public int totalPage() {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select count(*) cnt from li_book ";

			PreparedStatement ps = new LoggableStatement(con, query);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {				
				result = rs.getInt("cnt");
			}
			
			ps.close();
			con.close();
			rs.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 페이지 검색
	public int totalPage(String book_name) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
			
			// # SQL 준비
			String query =  " select count(*) cnt from li_book join book using(book_isbn) ";
			query +=  " where lower(book_name) like lower('%'||?||'%') ";
			
			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setString(1, book_name);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {				
				result = rs.getInt("cnt");
			}
			
			ps.close();
			con.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 상세내역
	public InvenDTO bookCount(long book_isbn) {
		InvenDTO dto = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select b.*, ";
			query += " (select count(*) as cnt from book join li_book using (book_isbn) where book_isbn = ?) as cnt, ";
			query += " (select sum(book_loan_seq) from li_book where book_isbn = ?) as book_loan_seq ";
			query += " from book b where book_isbn = ? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setLong(1, book_isbn);
            ps.setLong(2, book_isbn);
            ps.setLong(3, book_isbn);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				dto = new InvenDTO();
				
				dto.setBook_ISBN(rs.getLong("book_isbn"));
				dto.setBook_img(rs.getString("book_img"));
				dto.setBook_author(rs.getString("book_author"));
				dto.setBook_name(rs.getString("book_name"));
				dto.setBook_pub(rs.getString("book_pub"));
				dto.setCount(rs.getInt("cnt"));
				dto.setBook_loan_seq(rs.getInt("book_loan_seq"));
				
				
			}
			ps.close();
			con.close();
			rs.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}
