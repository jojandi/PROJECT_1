package user.dao.noti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class NotiDAO {
    
	
	public List<NotiDAO> getAllBookRequests() {
        List<NotiDAO> list = new ArrayList<>();

        try {
            // 데이터베이스 연결
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();
            
            //sql 준비
            String query ="select a.ann_title,a.ann_detail,a.ann_regi,a.ann_check,ann_class" +
        				"VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            
            // 결과 덩어리 전체
            ResultSet rs = ps.executeQuery();

            // 결과를 리스트에 저장
            while (rs.next()) {

       


               
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;  
    }
}