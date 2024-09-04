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
import admin.DTO.inven.LoanResDTO;


public class ResDAO {
	
	// 회원 예약 내역
	public List memResList() {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select book_code, res_id, res_day, res_pick, user_seq, book_name, (res_pick - res_day) as res_ing  ";
			query += " from user_res join li_book using(book_code) join book using(book_isbn) ";
			query += " order by res_id desc ";

            PreparedStatement ps = new LoggableStatement(con, query);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				LoanResDTO dto = new LoanResDTO();
				
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
	
	// 회원 예약 내역 업데이트
	public int memResUpdate(LoanResDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
      
			String query = "update user_res ";
			query += " set res_pick = to_date(sysdate, 'YYYY-MM-DD') ";
			query += " where res_id = ? ";

			PreparedStatement ps = new LoggableStatement(con, query);
			
			ps.setInt(1, dto.getRes_id());
	      
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
	      	result = ps.executeUpdate(); // 몇 줄이 업데이트 되었는지 int로 받음
	      
	      	ps.close();
	      	con.close();
            
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 회원 예약 업데이트 후 대출 내역으로 이동
	public int resLoan(LoanResDTO dto) {
		int result = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = " insert into user_loan(loan_seq, book_code, user_seq, loan_date, loan_ing, loan_ex, loan_over) ";
			query += " values (user_loan_seq.nextval, ?, ?, sysdate, 'Y', sysdate + 7, 'N') ";

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
	
	// 대출 시 재고에 대출중 표시
	public int invenUpdate(InvenDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
		    
			String query = " update li_book ";
			query += " set book_loan = ";
			query += " case when  ";
			query += " (select loan_ing from li_book join user_loan using(book_code) ";
			query += " where loan_ing='Y' and book_code=?) = 'Y'  then 'Y' else 'N' end  ";
			query += "  where book_code=? ";

			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, dto.getBook_code());
			ps.setInt(2, dto.getBook_code());
	      
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
	      	result = ps.executeUpdate(); // 몇 줄이 업데이트 되었는지 int로 받음
	      
	      	ps.close();
	      	con.close();
            
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 픽업 시 재고에 - 표시
	public int invenUpdate2(InvenDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
		    
			String query = " update li_book ";
			query += " set book_res = ";
			query += " case when  ";
			query += " (select res_pick from li_book join user_res using(book_code) ";
			query += " where res_pick is null and book_code=?) = 'null'  then 'N' else 'Y' end  ";
			query += "  where book_code=? ";

			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, dto.getBook_code());
			ps.setInt(2, dto.getBook_code());
	      
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
	      	result = ps.executeUpdate(); // 몇 줄이 업데이트 되었는지 int로 받음
	      
	      	ps.close();
	      	con.close();
            
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
