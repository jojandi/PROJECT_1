package user.dao.loan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.loan.LoanDTO;


public class LoanDAO {

	public List myLoan(int seq) {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select loan_seq, book_code, user_seq, book_name, loan_date, loan_ing, loan_return, loan_ex, (loan_ex - loan_return) as isOver ";
			query += " from user_loan join tbl_user using(user_seq) join li_book using(book_code)  ";
			query += " join book using(book_isbn) where user_seq = ? ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, seq);
			
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
				
//				dto.setUser_pass(rs.getDate("user_pass"));
//				dto.setUser_loan(rs.getInt("user_loan"));
				
//				String loan_over = rs.getString("loan_over");
//				String user_over = rs.getString("user_over");
//				String book_loan = rs.getString("book_loan");
				
				
				if("Y".equals(loan_ing)) {
					dto.setLoan_ing(true);
				} else {
					dto.setLoan_ing(false);
				}
//				if("Y".equals(loan_over)) {
//					dto.setLoan_over(true);
//				} else {
//					dto.setLoan_over(false);
//				}
//				if("Y".equals(user_over)) {
//					dto.setUser_over(true);
//				} else {
//					dto.setUser_over(false);
//				}
				
//				if("Y".equals(book_loan)) {
//					dto.setBook_loan(true);
//				} else {
//					dto.setBook_loan(false);
//				}

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

}
