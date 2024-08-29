package user.dao.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.search.SearchDTO;

public class SearchDAO {
	
	// 도서검색
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
				SearchDTO dto = new SearchDTO();
								
				dto.setBook_code(rs.getInt("book_code"));
				dto.setLi_book_info(rs.getString("li_book_info"));
				dto.setBook_ISBN(rs.getLong("book_isbn"));
				dto.setBook_img(rs.getString("book_img"));
				dto.setBook_author(rs.getString("book_author"));
				dto.setBook_name(rs.getString("book_name"));
				dto.setBook_pub(rs.getString("book_pub"));
				
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
