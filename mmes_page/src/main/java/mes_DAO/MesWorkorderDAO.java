package mes_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mes_DTO.MesHumanDTO;
import mes_DTO.MesWorkorderDTO;
import mes_DTO.MesWorkorderWoDTO;


public class MesWorkorderDAO {
	public List<MesWorkorderDTO> selectAll() {
		List<MesWorkorderDTO> list = new ArrayList<MesWorkorderDTO>();
			
		try {
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
		
			String query = " SELECT * From bom order by bom_code" ;
		
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
			
				
				int bom_code = rs.getInt("bom_code");
				String bom_name = rs.getString("bom_name");
				int mes_book_code1 = rs.getInt("mes_book_code1");
				int mes_book_code2 = rs.getInt("mes_book_code2");
				int mes_book_code3 = rs.getInt("mes_book_code3");
				
				MesWorkorderDTO dto = new MesWorkorderDTO();
				dto.setBom_code(bom_code);
				dto.setBom_name(bom_name);
				dto.setMes_book_code1(mes_book_code1);
				dto.setMes_book_code2(mes_book_code2);
				dto.setMes_book_code3(mes_book_code3);
				
				
				list.add(dto);
				
				
					
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	public List<MesWorkorderDTO> selectMesBook(){
		List<MesWorkorderDTO> list = new ArrayList<MesWorkorderDTO>();
		
	     
	     
	    try {
	    	 
	    	 // DB 접속
	    	 Context ctx = new InitialContext();
			 DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			 Connection con = dataSource.getConnection();
	    	 
	    	 // SQL 준비
			 String query = " SELECT m.mes_book_code, b.book_name, b.book_isbn, b.book_author, b.book_pub, m.book_count, m.wh_code";
			 query += " FROM book b ";
			 query += " JOIN mes_book m ON b.book_isbn = m.book_isbn";
	    	 PreparedStatement ps = con.prepareStatement(query);
	    	 
	    	 // SQL 실행 및 결과 확보
	    	 ResultSet rs = ps.executeQuery();
	    	 
	    	 System.out.println("쿼리 실행 중...");
	    	 // 결과 활용
	    	 // re.next() 다음줄이 있는가?
	    	 while(rs.next()) {
	    		 // 전달인자로 컬럼명을 적고 그 내용을 형변환 해서 가지고 온다
	    		 
	    		 int mes_book_code = rs.getInt("mes_book_code");
	    		 String book_name = rs.getString("book_name");
	    		 long book_isbn = rs.getLong("book_isbn");
	    		 String book_author =rs.getString("book_author");
	    		 String book_pub = rs.getString("book_pub");
	    		 long book_count = rs.getLong("book_count");
	    		 String wh_code = rs.getString("wh_code");
	    		 
	    		 MesWorkorderDTO dto = new MesWorkorderDTO();
	    		 
	    		 dto.setMes_book_code(mes_book_code);
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
	
	public List<MesWorkorderDTO> selectOne(int bom_code) {
	    List<MesWorkorderDTO> bookList = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        // DB 접속
	        Context ctx = new InitialContext();
	        DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	        con = dataFactory.getConnection();
	        
	        // SQL 준비
	        String query = "SELECT m.mes_book_code, b.book_name, b.book_isbn, b.book_author, b.book_pub, m.book_count, m.wh_code "
	                     + "FROM book b "
	                     + "JOIN mes_book m ON b.book_isbn = m.book_isbn "
	                     + "WHERE m.mes_book_code IN ("
	                     + "  SELECT mes_book_code1 FROM bom WHERE bom_code = ? "
	                     + "  UNION ALL "
	                     + "  SELECT mes_book_code2 FROM bom WHERE bom_code = ? "
	                     + "  UNION ALL "
	                     + "  SELECT mes_book_code3 FROM bom WHERE bom_code = ? "
	                     + ")";
	        
	        ps = con.prepareStatement(query);
	        ps.setInt(1, bom_code);
	        ps.setInt(2, bom_code);
	        ps.setInt(3, bom_code);
	        
	        // SQL 실행
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            MesWorkorderDTO workorderDTO = new MesWorkorderDTO();
	            workorderDTO.setMes_book_code(rs.getInt("mes_book_code"));
	            workorderDTO.setBook_name(rs.getString("book_name"));
	            workorderDTO.setBook_isbn(rs.getLong("book_isbn"));
	            workorderDTO.setBook_author(rs.getString("book_author"));
	            workorderDTO.setBook_pub(rs.getString("book_pub"));
	            workorderDTO.setBook_count(rs.getLong("book_count"));
	            workorderDTO.setWh_code(rs.getString("wh_code"));
	            
	            bookList.add(workorderDTO);
	        }
	        System.out.println("쿼리 실행 완료");
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    
	    return bookList;
	}
	 public int insert(MesWorkorderDTO dto) {
	        int result = -1;
	        
	        try {
	            // DataSource를 사용하여 DB 연결
	            Context ctx = new InitialContext();
	            DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
	            Connection con = dataFactory.getConnection();
	            
	            // SQL 쿼리 준비
	            String query = "INSERT INTO bom (bom_code, bom_name, mes_book_code1, mes_book_code2, mes_book_code3) "
	                         + "VALUES (?, ?, ?, ?, ?)";
	            
	            PreparedStatement ps = con.prepareStatement(query);
	            
	            // DTO에서 값 가져오기
	            int bom_code = dto.getBom_code();
	            String bom_name = dto.getBom_name(); 
	            Integer mes_book_code1 = dto.getMes_book_code1();
	            Integer mes_book_code2 = dto.getMes_book_code2();
	            Integer mes_book_code3 = dto.getMes_book_code3();
	            
	            // PreparedStatement에 값 설정
	            ps.setInt(1, bom_code);
	            ps.setString(2, bom_name); // bomName is assumed to be a String
	            ps.setObject(3, mes_book_code1 != null ? mes_book_code1 : null, java.sql.Types.INTEGER); // handle null
	            ps.setObject(4, mes_book_code2 != null ? mes_book_code2 : null, java.sql.Types.INTEGER); // handle null
	            ps.setObject(5, mes_book_code3 != null ? mes_book_code3 : null, java.sql.Types.INTEGER); // handle null
	            
	            
	            // SQL 실행
	            result = ps.executeUpdate();
	            
	            ps.close();
	            con.close();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return result;
	    }
	 
	 public int deleteOne(int bom_code) {
			int result = -1;
			
			try {
				// DB 접속
				Context ctx = new InitialContext();
				DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
				Connection con = dataFactory.getConnection();
				
				// SQL 준비
				String query = "delete from bom where bom_code = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, bom_code);
				System.out.println(bom_code);
				// SQL 실행
				result = ps.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
	 public int updateBook(MesWorkorderDTO workDTO) {
			int result = -1;
			
			try {
				
				Context ctx = new InitialContext();
				DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
				// DB 접속 : 커넥션풀을 사용해서 
				Connection con = dataFactory.getConnection();
				
				// SQL 준비
				String query = "UPDATE bom_table SET bom_name = ?, mes_book_code1 = ?, mes_book_code2 = ?, mes_book_code3 = ? WHERE mes_book_code = ?";
				
				PreparedStatement ps = con.prepareStatement(query);
				
				 ps.setString(1, workDTO.getBom_name());
		         ps.setInt(2, workDTO.getMes_book_code1());
		         ps.setInt(3, workDTO.getMes_book_code2());
		         ps.setInt(4, workDTO.getMes_book_code3());
		         ps.setInt(5, workDTO.getBom_code());
		        
				// SQL 실행
				result = ps.executeUpdate();
				
				ps.close();
				con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
	 
	 public MesWorkorderDTO selectBookByCode(int bookCode)  {
		 MesWorkorderDTO book = null;
		 try {
			 
			 Context ctx = new InitialContext();
			 DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			 // DB 접속 : 커넥션풀을 사용해서 
			 Connection con = dataFactory.getConnection();
			 
			 // SQL 준비
			 String query = "SELECT * FROM mes_workorder WHERE mes_book_code = ?";
			 
			 PreparedStatement ps = con.prepareStatement(query);
			 ps.setInt(1, bookCode);
			 try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    book = new MesWorkorderDTO();
	                    book.setMes_book_code(rs.getInt("mes_book_code"));
	                    book.setBook_name(rs.getString("book_name"));
	                    book.setBook_isbn(rs.getLong("book_isbn"));
	                    book.setBook_author(rs.getString("book_author"));
	                    book.setBook_pub(rs.getString("book_pub"));
	                    book.setBook_count(rs.getInt("book_count"));
	                    book.setWh_code(rs.getString("wh_code"));
	                }
	            }
			
			 
			 ps.close();
			 con.close();
			 
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		 return book;
	 }
	
	
}
