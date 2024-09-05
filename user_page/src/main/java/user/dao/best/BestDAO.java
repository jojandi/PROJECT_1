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
				query += " book_img, li_book_info, book_loan, book_loan_seq ";
				query += " FROM book JOIN li_book USING (book_isbn))";
				query += " select * from (SELECT book_name, book_pub, book_author, book_isbn, ";
				query += " SUM(book_loan_seq) AS total_loan_seq, ";
				query += " MAX(CASE WHEN book_loan = 'N' AND rn = 1 THEN book_code END) AS book_code, ";
				query += " COUNT(*) AS count, book_img, li_book_info ";
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
	
}
