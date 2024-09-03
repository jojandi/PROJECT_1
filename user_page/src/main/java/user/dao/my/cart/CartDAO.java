package user.dao.my.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dao.my.loan.LoggableStatement;
import user.dto.my.cart.CartDTO;

public class CartDAO {
	
	// 장바구니 내역
	public List myCart(int seq) {
		List list = new ArrayList();
		
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// 커넥션 풀에서 접속 정보 가져오기
			Connection con = dataFactory.getConnection();
		  
			// # SQL 준비
			String query =  " select book_code, cart_seq, user_seq, li_book_info, book_name, book_author, book_pub, book_img ";
			query += " from user_cart join li_book using(book_code) join book using(book_isbn) where user_seq = ? ";
			query += " order by cart_seq ";

            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, seq);
			
			System.out.println(((LoggableStatement)ps).getQueryString()); // 실행문 출력
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				CartDTO dto = new CartDTO();
				
				dto.setCart_seq(rs.getInt("cart_seq"));
				dto.setBook_code(rs.getInt("book_code"));
				dto.setUser_seq(rs.getInt("user_seq"));
				dto.setBook_name(rs.getString("book_name"));
				dto.setLi_book_info(rs.getString("li_book_info"));
				dto.setBook_author(rs.getString("book_author"));
				dto.setBook_pub(rs.getString("book_pub"));
				dto.setBook_img(rs.getString("book_img"));

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
