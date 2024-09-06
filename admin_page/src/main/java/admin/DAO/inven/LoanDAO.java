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

public class LoanDAO {
	
	// 회원 대출 내역
	public List memLoanList() {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select loan_seq, book_code, user_seq, book_name, loan_date, loan_ing, loan_return, loan_ex, (loan_ex - loan_return) as isOver ";
			query += " from user_loan join li_book using(book_code)  ";
			query += " join book using(book_isbn) ";
			query += " order by book_loan desc, loan_date desc ";

            PreparedStatement ps = new LoggableStatement(con, query);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				LoanResDTO dto = new LoanResDTO();
				
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
				
				System.out.println("dto : " + dto);
				
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

	// 회원 대출 내역 업데이트
	public int memLoanUpdate(LoanResDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
      
			String query = "update user_loan ";
			query += " set loan_ing = ?, ";
			query += " loan_return = sysdate, ";
			query += " loan_over =  ";
			query += " case when (select (loan_ex - loan_return) as over from user_loan where loan_seq = ? ) ";
			query += "  >= 0 then 'N' else 'Y' end   ";
			query += " where loan_seq = ? ";

			PreparedStatement ps = new LoggableStatement(con, query);
			
			String loan_ing = null;
			if(dto.isLoan_ing() == true) {
				loan_ing = "Y";
			} else {
				loan_ing = "N";
			}
			
			ps.setString(1, loan_ing);
			ps.setInt(2, dto.getLoan_seq());
			ps.setInt(3, dto.getLoan_seq());
	      
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
	      	result = ps.executeUpdate(); // 몇 줄이 업데이트 되었는지 int로 받음
	      
	      	ps.close();
	      	con.close();
            
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 반납 시 재고에 - 표시
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
	
	// 반납 시 연체 여부 회원 없데이트
	public int memberUpdate(LoanResDTO dto) {
		int result = -1;
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
		    
			String query = " update tbl_user ";
			query += " set user_pass = case when ";
			query += " case when ";
			query += " (select (loan_return - loan_ex) as over_date from user_loan where loan_seq = ?) > 0 then  ";
			query += " (select loan_return + (loan_return - loan_ex) as user_pass from user_loan where loan_seq = ?) ";
			query += " else null end  ";
			query += " where user_seq= ? ";

			PreparedStatement ps = new LoggableStatement(con, query);
			ps.setInt(1, dto.getUser_seq());
			ps.setInt(2, dto.getBook_code());
			ps.setInt(3, dto.getBook_code());
	      
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
