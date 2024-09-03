package admin.DAO.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import admin.DTO.app.AppDTO;


public class AppDAO {

    // 도서 신청 목록을 가져오는 메서드
    public List userList() {
        List<Object> list = new ArrayList<>();

        String query = "SELECT * FROM application";  

        try {
            // 데이터베이스 연결
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // 결과를 리스트에 저장
            while (rs.next()) {
                AppDTO appDTO = new AppDTO();
                appDTO.setAnn_seq(rs.getInt("app_seq"));
                appDTO.setApp_book(rs.getString("app_book"));
                appDTO.setApp_name(rs.getString("app_name"));
                appDTO.setApp_pub(rs.getString("app_pub"));
                appDTO.setApp_date(rs.getInt("app_date"));
                appDTO.setUser_seq(rs.getString("user_seq"));

                list.add(appDTO);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;  
    }

    // 도서 신청 정보를 삽입하는 메서드
    public static int insertApp(AppDTO dto) {
        int result = -1;  // 기본 결과값 설정

        String query = "INSERT INTO app_table (app_seq, app_book, app_name, app_pub, app_date, user_seq) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // 데이터베이스 연결
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dto.getAnn_seq());
            ps.setString(2, dto.getApp_book());
            ps.setString(3, dto.getApp_name());
            ps.setString(4, dto.getApp_pub());
            ps.setInt(5, dto.getApp_date());
            ps.setString(6, dto.getUser_seq());

<<<<<<< HEAD
            System.out.println(((LoggableStatement) ps).getQueryString());

            // SQL 실행
            result = ps.executeUpdate();

=======
            result = ps.executeUpdate();  
          
>>>>>>> 6e7ed592006c2331d9483d56706df8d036e16705
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return result;  
    }

	public List selectApp() {
		return null;
	}
}
