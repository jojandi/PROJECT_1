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

import mes_DTO.MesNoticeDTO;
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
			 String query = "select m.mes_book_code,b.book_name, b.book_isbn, b.book_author, b.book_pub, m.book_count, m.wh_code " +
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
	    		 
	    		 long mes_book_code = rs.getLong("mes_book_code");
	    		 String book_name = rs.getString("book_name");
	    		 long book_isbn = rs.getLong("book_isbn");
	    		 String book_author =rs.getString("book_author");
	    		 String book_pub = rs.getString("book_pub");
	    		 long book_count = rs.getLong("book_count");
	    		 String wh_code = rs.getString("wh_code");
	    		 
	    		 MesStockDTO dto = new MesStockDTO();
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
	
	public List<MesStockDTO> selectOrder(){
		List<MesStockDTO> list = new ArrayList<MesStockDTO>();
		
	     
	     
	    try {
	    	 
	    	 // DB 접속
	    	 Context ctx = new InitialContext();
			 DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			 Connection con = dataSource.getConnection();
	    	 
	    	 // SQL 준비
			 String query = "select mes_book_code, order_id, pub_name, order_st, emp_name, order_date";
					query += " from tbl_order t, publisher p, employee e";
					query += " where t.emp_id = e.emp_id";
					query += " and t.pub_id = p.pub_id";

	    	 PreparedStatement ps = con.prepareStatement(query);
	    	 
	    	 // SQL 실행 및 결과 확보
	    	 ResultSet rs = ps.executeQuery();
	    	 
	    	 System.out.println("쿼리 실행 중...");
	    	 // 결과 활용
	    	 // re.next() 다음줄이 있는가?
	    	 while(rs.next()) {
	    		 // 전달인자로 컬럼명을 적고 그 내용을 형변환 해서 가지고 온다
	    		 Long mes_book_code = rs.getLong("mes_book_code");
	    		 String order_id = rs.getString("order_id");
	    		 String pub_name = rs.getString("pub_name");
	    		 String order_st = rs.getString("order_st");
	    		 String emp_name = rs.getString("emp_name");
	    		 Date order_date = rs.getDate("order_date");
	    		 
	    		 MesStockDTO dto = new MesStockDTO();
		    	 dto.setMes_book_code(mes_book_code);
		    	 dto.setOrder_id(order_id);
		    	 dto.setPub_name(pub_name);
		    	 dto.setOrder_st(order_st);
		    	 dto.setEmp_name(emp_name);
		    	 dto.setOrder_date(order_date);
	    		 
	    		 
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
	// 부품 코드를 리스트로 반환하는 메서드
    public List<String> getMesBookCodes() {
        List<String> mesBookCodes = new ArrayList<>();
        
        try {
        	Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();
			
			String query = "SELECT mes_book_code FROM mes_book";
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
            while (rs.next()) {
                mesBookCodes.add(rs.getString("mes_book_code"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mesBookCodes;
    }
 // 발주처를 리스트로 반환하는 메서드
    public List<String> getMesPubId() {
        List<String> mesPubId = new ArrayList<>();
        
        try {
        	Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();
			
			String query = "SELECT pub_id FROM publisher";
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
            while (rs.next()) {
            	mesPubId.add(rs.getString("pub_id"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mesPubId;
    }
    public int order(MesStockDTO MesStockDTO) {

		int result = -1;

		try {

			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = "INSERT INTO tbl_order (order_id, order_date, order_count, order_st, emp_ID, pub_id, mes_book_code)";
				   query += " VALUES (tbl_order_seq.NEXTVAL, sysdate, ?, '진행중', 1, ?, ?)";
			
			

			// PreparedStatement ps = con.prepareStatement(query);
			// 원래 실행되는 걸 LoggableStatement가 가로채서
			PreparedStatement ps = new LoggableStatement(con, query);
			
			ps.setLong(1, MesStockDTO.getOrder_count());
			
			ps.setString(2, MesStockDTO.getPub_id());
			System.out.println(MesStockDTO.getPub_id());
			
			ps.setLong(3, MesStockDTO.getMes_book_code());


			// 실제 실행되는 sql을 출력해볼 수 있다
			System.out.println(((LoggableStatement) ps).getQueryString());

			// SQL 실행
			result = ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
    
    public List<MesStockDTO> selectProduct(){
		List<MesStockDTO> list = new ArrayList<MesStockDTO>();
		
	     
	    try {
	    	 
	    	 // DB 접속
	    	 Context ctx = new InitialContext();
			 DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			 Connection con = dataSource.getConnection();
	    	 
	    	 // SQL 준비
			 String query = "select b.bom_code,b.bom_name, p.pd_count, w.wh_name, p.pd_note";
					query += " from warehouse w, product p , bom b";
					query += " where w.wh_code = p.wh_code";
					query += " and p.bom_code = b.bom_code";


	    	 PreparedStatement ps = con.prepareStatement(query);
	    	 
	    	 // SQL 실행 및 결과 확보
	    	 ResultSet rs = ps.executeQuery();
	    	 
	    	 System.out.println("쿼리 실행 중...");
	    	 // 결과 활용
	    	 // re.next() 다음줄이 있는가?
	    	 while(rs.next()) {
	    		 // 전달인자로 컬럼명을 적고 그 내용을 형변환 해서 가지고 온다
	    		 long bom_code = rs.getLong("bom_code");
	    		 String bom_name = rs.getString("bom_name");
	    		 long pd_count = rs.getLong("pd_count");
	    		 String wh_name = rs.getString("wh_name");
	    		 String pd_note = rs.getString("pd_note");
	    		 
	    		 MesStockDTO dto = new MesStockDTO();
		    	 dto.setBom_code(bom_code);
		    	 dto.setBom_name(bom_name);
		    	 dto.setPd_count(pd_count);
		    	 dto.setWh_name(wh_name);
		    	 dto.setPd_note(pd_note);
	    		 
	    		 
	    		 list.add(dto);
	    		 System.out.println("productList"+dto);
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
    
    public MesStockDTO getStockOrder(int order_id) {
    	MesStockDTO dto = null;

		try {

			// DB 접속
	    	 Context ctx = new InitialContext();
			 DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			 Connection con = dataSource.getConnection();
	    	 
	    	 // SQL 준비
			 String query = "select * from tbl_order";
			 		query += " where order_id=?";


	 		 PreparedStatement ps = con.prepareStatement(query);
			 // ?를 값으로 채워줌
			 // 첫번째 전달인자는 ?의 순서
			 // 만약에 글씨라면 setString, 알아서 '로 감싸준다
			 ps.setInt(1, order_id);
			 		
	    	 
	    	 // SQL 실행 및 결과 확보
	    	 ResultSet rs = ps.executeQuery();

			// 결과 활용
			if (rs.next()) {
				dto = new MesStockDTO();
				dto.setOrder_id(rs.getString("order_id"));
				dto.setOrder_date(rs.getDate("order_date"));
				dto.setOrder_price(rs.getLong("order_price"));
				dto.setOrder_count(rs.getLong("order_count"));
				dto.setOrder_st(rs.getString("order_st"));
				dto.setEmp_id(rs.getLong("emp_id"));
				dto.setPub_id(rs.getString("pub_id"));
				dto.setMes_book_code(rs.getLong("mes_book_code"));
			}
			System.out.println("getStockOrder dto:"+dto);
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
    public int deleteOrder(MesStockDTO MesStockDTO) {

		int result = -1;

		try {

			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = "delete from tbl_order where order_id = ?";
					
			

			PreparedStatement ps = new LoggableStatement(con, query);
			
			ps.setString(1, MesStockDTO.getOrder_id());
			


			// 실제 실행되는 sql을 출력해볼 수 있다
			System.out.println(((LoggableStatement) ps).getQueryString());

			// SQL 실행
			result = ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
    public int updateMesBook(MesStockDTO MesStockDTO) {

		int result = -1;

		try {

			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 dataSource로 저장하기
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB접속 : 커넥션풀을 사용해서
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = "UPDATE mes_book";
				   query += " SET book_count = book_count + ?";
				   query += " WHERE mes_book_code = ?";
					
			

			PreparedStatement ps = new LoggableStatement(con, query);
			
			ps.setLong(1, MesStockDTO.getOrder_count());
			ps.setLong(2, MesStockDTO.getMes_book_code());
			


			// 실제 실행되는 sql을 출력해볼 수 있다
			System.out.println(((LoggableStatement) ps).getQueryString());

			// SQL 실행
			result = ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
    
    //페이징----------------------------------------------------------------------------------------------
    public List<MesStockDTO> selectStockPage2(int start, int end) {
        List<MesStockDTO> list = new ArrayList<>();
        
        try {
            // DB 접속
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            // SQL 준비
            String query =  "SELECT *";
            	   query += " FROM (";
            	   query += " SELECT rownum rnum,";
            	   query += " mes_book.book_isbn,";
            	   query += " book.book_name,";
            	   query += " book.book_author,";
            	   query += " book.book_pub,";
            	   query += " mes_book.book_count,";
            	   query += " mes_book.wh_code";
            	   query += " FROM mes_book";
            	   query += " LEFT JOIN book ON mes_book.book_isbn = book.book_isbn";
            	   query += " ORDER BY mes_book.book_isbn";
            	   query += ")";
            	   query += " WHERE rnum >= ? AND rnum <= ?";
           
            
            PreparedStatement ps = new LoggableStatement(con, query);
            ps.setInt(1, start);
            ps.setInt(2, end);
            
            System.out.println(((LoggableStatement)ps).getQueryString());
            
            // SQL 실행 및 결과 확보
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MesStockDTO dto = new MesStockDTO();
                
                // 각 컬럼의 값을 DTO에 설정
                dto.setBook_isbn(rs.getLong("book_isbn"));
                dto.setBook_name(rs.getString("book_name"));
                dto.setBook_author(rs.getString("book_author"));
                dto.setBook_pub(rs.getString("book_pub"));
                dto.setBook_count(rs.getLong("book_count"));
                dto.setWh_code(rs.getString("wh_code"));  // 정확한 wh_code 사용
                dto.setRnum(rs.getInt("rnum"));
                
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





	
    public int totalStockPage2() {
        int result = -1;
        
        try {
            // DB 접속
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            // SQL 준비
            String query = " SELECT COUNT(*) AS cnt ";
            query += " FROM mes_book mb ";
            query += " LEFT JOIN book b ON mb.book_isbn = b.book_isbn ";  // book 테이블과 조인하여 book_name, book_author, book_pub 참조

            PreparedStatement ps = new LoggableStatement(con, query);
            
            System.out.println(((LoggableStatement)ps).getQueryString());
            
            // SQL 실행 및 결과 확보
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("cnt");  // 총 레코드 수 계산
            }
            
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }



    
    
    
    
}
