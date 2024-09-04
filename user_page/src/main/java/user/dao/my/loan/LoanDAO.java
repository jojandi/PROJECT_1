package user.dao.my.loan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.my.loan.LoanDTO;


public class LoanDAO {

	// 대출내역
	public List myLoan(int seq, int start, int end) {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select * from( ";
			query += " select rownum as rnum, loan_seq, book_code, user_seq, book_name, loan_date, loan_ing, loan_return, loan_ex, isOver  ";
			query += " from (  ";
			query += " select loan_seq, book_code, user_seq, book_name, loan_date, loan_ing, loan_return, loan_ex, (loan_ex - loan_return) as isOver ";
			query += " from user_loan join li_book using(book_code) join book using(book_isbn) where user_seq = ? ";
			query += " order by loan_date desc ) ";
			query += " ) where rnum >=? and rnum <= ? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, seq);
            ps.setInt(2, start);
            ps.setInt(3, end);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				LoanDTO dto = new LoanDTO();
				
				dto.setLoan_seq(rs.getInt("loan_seq"));
				dto.setBook_code(rs.getInt("book_code"));
				dto.setUser_seq(rs.getInt("user_seq"));
				dto.setLoan_date(rs.getDate("loan_date"));
				dto.setLoan_return(rs.getDate("loan_return"));
				dto.setLoan_ex(rs.getDate("loan_ex"));
				dto.setBook_name(rs.getString("book_name"));
				dto.setIsOver(rs.getInt("isover"));
				System.out.println(dto.getIsOver());
				
				String loan_ing = rs.getString("loan_ing");
				
				if("Y".equals(loan_ing)) {
					dto.setLoan_ing(true);
				} else {
					dto.setLoan_ing(false);
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
	
	// 연체 내역
	public List myOver(int seq, int start, int end) {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select * from( ";
			query += " select rownum as rnum, loan_seq, book_code, user_seq, book_name, loan_date, loan_return, over_date, user_pass ";
			query += " from ( select loan_seq, book_code, user_seq, book_name, loan_date, loan_return, (loan_return - loan_ex) as over_date, loan_return + (loan_return - loan_ex) as user_pass ";
			query += " from user_loan join li_book using(book_code) ";
			query += " join book using(book_isbn) where loan_return - loan_ex > 0 and user_seq = ? ";
			query += " order by loan_date desc";
			query += " )) where rnum >=? and rnum <= ? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, seq);
            ps.setInt(2, start);
            ps.setInt(3, end);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				LoanDTO dto = new LoanDTO();
				
				dto.setLoan_seq(rs.getInt("loan_seq"));
				dto.setBook_code(rs.getInt("book_code"));
				dto.setUser_seq(rs.getInt("user_seq"));
				dto.setLoan_date(rs.getDate("loan_date"));
				dto.setLoan_return(rs.getDate("loan_return"));
				dto.setBook_name(rs.getString("book_name"));
				dto.setOver(rs.getInt("over_date"));				
				dto.setUser_pass(rs.getDate("user_pass"));			

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
	
	// 예약내역
	public List myRes(int seq, int start, int end) {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select * from (select rownum as rnum, book_code, res_id, res_day, res_pick, user_seq, book_name, res_ing  ";
			query +=  " from ( select book_code, res_id, res_day, res_pick, user_seq, book_name, (res_pick - res_day) as res_ing  ";
			query += " from user_res join li_book using(book_code) join book using(book_isbn) where user_seq = ? ";
			query += " order by res_id ";
			query += " )) where rnum >=? and rnum <= ? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, seq);
            ps.setInt(2, start);
            ps.setInt(3, end);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				LoanDTO dto = new LoanDTO();
				
				dto.setRes_id(rs.getInt("res_id"));
				dto.setBook_code(rs.getInt("book_code"));
				dto.setUser_seq(rs.getInt("user_seq"));
				dto.setRes_day(rs.getDate("res_day"));
				dto.setRes_pick(rs.getDate("res_pick"));
				dto.setBook_name(rs.getString("book_name"));
				dto.setRes_ing(rs.getInt("res_ing"));
				
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
	
	// 전체 목록 개수 -> 대출
	public int totalLoan(int seq) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select count(*) cnt from user_loan where user_seq = ?";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, seq);
			
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
	// 전체 목록 개수 -> 연체
	public int totalOver(int seq) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select count(*) as cnt from user_loan join li_book using(book_code)  ";
			query += "join book using(book_isbn) where loan_return - loan_ex > 0 and user_seq = ? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, seq);
			
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
	
	// 전체 목록 개수 -> 예약
	public int totalRes(int seq) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select count(*) cnt from user_res where user_seq = ?";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, seq);
			
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

}
