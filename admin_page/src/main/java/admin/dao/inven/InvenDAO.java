package admin.dao.inven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import admin.dto.inven.InvenDTO;

public class InvenDAO {
	
	// 재고조회 검색
	public List bookList(String book_name) {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select * from book join li_book using (book_isbn) ";
			query += " where lower(book_name) like lower('%'||?||'%')";
			query += " order by to_number(book_code) ";
			

            PreparedStatement ps = new LoggableStatement(con, query);
            
            ps.setString(1, book_name);
			
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
				
				if("y".equals(book_loan)) {
					dto.setBook_loan(true);
				} else {
					dto.setBook_loan(false);
				}
				if("y".equals(book_res)) {
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
	
	// 재고조회
	public List bookList() {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select * from book join li_book using (book_isbn) ";
			query += " order by to_number(book_code) ";

            PreparedStatement ps = new LoggableStatement(con, query);
			
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
				
				if("y".equals(book_loan)) {
					dto.setBook_loan(true);
				} else {
					dto.setBook_loan(false);
				}
				if("y".equals(book_res)) {
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
			query += "(select count(*) as cnt from book join li_book using (book_isbn) ";
			query += "where book_isbn=?) as cnt from book b where book_isbn=? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setLong(1, book_isbn);
            ps.setLong(2, book_isbn);
			
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
