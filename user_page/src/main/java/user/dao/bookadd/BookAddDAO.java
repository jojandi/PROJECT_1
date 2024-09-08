package user.dao.bookadd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.app.AppDTO;

public class BookAddDAO {
	
public List	 one(int user_seq) {
    	
		List list = new ArrayList();

        try {
            // DB 연결
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            // SQL 쿼리 작성 
            String query = " select user_seq, app_book, app_date, purchased from  application ";
            		query += " where user_seq = ? ";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user_seq);

            // SQL 실행 및 결과 획득
            ResultSet rs = ps.executeQuery();

            // 결과 처리
            while (rs.next()) {
            	AppDTO app = new AppDTO();
            	app.setUser_seq(rs.getString("user_seq"));
            	app.setApp_book(rs.getString("app_book"));
            	app.setApp_date(rs.getDate("app_date"));
            	app.setPurchased(rs.getString("purchased"));
                
            	list.add(app);
            }

            // 리소스 정리
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
	
}
