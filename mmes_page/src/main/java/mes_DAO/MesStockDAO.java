package mes_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mes_DTO.MesStockDTO;



public class MesStockDAO {
	
	public List<MesStockDTO> selectMesBook(){
		List<MesStockDTO> list = new ArrayList<MesStockDTO>();
		
	     
	     
	    try {
	    	 
	    	 // DB 접속
	    	 Context ctx = new InitialContext();
			 DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			 Connection con = dataSource.getConnection();
	    	 
	    	 // SQL 준비
			 String query = "select b.book_name, b.book_isbn, b.book_author, b.book_pub, m.book_count, m.wh_code " +
		               "from book b, mes_book m " +
		               "WHERE b.book_isbn = m.book_isbn";
	    	 PreparedStatement ps = con.prepareStatement(query);
	    	 
	    	 // SQL 실행 및 결과 확보
	    	 ResultSet rs = ps.executeQuery();
	    	 
	    	 System.out.println("쿼리 실행 중...");
	    	 // 결과 활용
	    	 // re.next() 다음줄이 있는가?
	    	 while(rs.next()) {
	    		 // 전달인자로 컬럼명을 적고 그 내용을 형변환 해서 가지고 온다
	    		 
	    		 String book_name = rs.getString("book_name");
	    		 long book_isbn = rs.getLong("book_isbn");
	    		 String book_author =rs.getString("book_author");
	    		 String book_pub = rs.getString("book_pub");
	    		 long book_count = rs.getLong("book_count");
	    		 String wh_code = rs.getString("wh_code");
	    		 
	    		 MesStockDTO dto = new MesStockDTO();
	    		 dto.setBook_name(book_name);
	    		 dto.setBook_isbn(book_isbn);
	    		 dto.setBook_author(book_author);
	    		 dto.setBook_pub(book_pub);
	    		 dto.setBook_count(book_count);
	    		 dto.setWh_code(wh_code);
	    		 
	    		 
	    		 list.add(dto);
	    	 }
	    	 System.out.println("쿼리 실행 완료");
	    	 rs.close();
	    	 ps.close();
	    	 con.close();
	     } catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     
	     return list;
	}
	
}
