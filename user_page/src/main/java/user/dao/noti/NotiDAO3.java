package user.dao.noti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.noti.NotiDTO;

public class NotiDAO3 {

    // 페이지 크기
    private static final int PAGE_SIZE = 10;

    // 특정 페이지의 공지사항을 가져오는 메서드
    public NotiDTO getNotiByPage(int ann_seq) {
    	
    	NotiDTO noti = new NotiDTO();

        try {
            // DB 연결
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            // SQL 쿼리 작성 
            String query = " select ann_seq, class, ann_title, ann_regi, ann_check, ann_detail from announcement a, ann_class c ";
            		query += " where a.class_id = c.class_id ";
            		query += " and a.ann_seq = ? ";
                         
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ann_seq);

            // SQL 실행 및 결과 획득
            ResultSet rs = ps.executeQuery();

            // 결과 처리
            while (rs.next()) {
                noti = new NotiDTO();
                noti.setAnn_Seq(rs.getInt("ann_seq"));
                noti.setClass_name(rs.getString("class"));
                noti.setAnn_Title(rs.getString("ann_title"));
                noti.setAnn_Regi(rs.getString("ann_regi"));
                noti.setAnn_Check(rs.getInt("ann_check"));
                noti.setAnn_Detail(rs.getString("ann_detail"));  // 공지사항 내용 추가

            }

            // 리소스 정리
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return noti;
    }
}
