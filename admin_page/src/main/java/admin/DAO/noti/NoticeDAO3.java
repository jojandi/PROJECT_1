package admin.DAO.noti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import admin.DTO.notice.NoticeDTO;
import admin.DTO.notice.NoticeDTO2;

public class NoticeDAO3 {

	public class AppController extends HttpServlet {
    // DB 연결을 위한 메서드
    private Connection getConnection() throws Exception {
        Context ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
        return dataSource.getConnection();
    }
    // 공지사항 ID로 공지사항의 세부 정보를 조회하는 메서드
    public NoticeDTO getNoticeById(String noticeId) {
        NoticeDTO notice = null;

        String query = "SELECT * FROM notice WHERE ann_seq = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, noticeId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    notice = new NoticeDTO();
                    notice.setAnn_seq(rs.getInt("ann_seq"));
                    notice.setClass_id(rs.getString("class_id"));
                    notice.setAnn_title(rs.getString("ann_title"));
                    notice.setAnn_detail(rs.getString("ann_detail"));
                    notice.setAnn_regi(rs.getString("ann_regi"));
                    notice.setAnn_check(rs.getInt("ann_check"));
                    notice.setAnn_attach(rs.getString("ann_attach"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return notice;
    }
    
    
	}
public NoticeDTO getNotiByPage(int ann_seq) {
    	
	NoticeDTO noti = new NoticeDTO();

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
                noti = new NoticeDTO();
                noti.setAnn_seq(rs.getInt("ann_seq"));
                noti.setClass_id(rs.getString("class"));
                noti.setAnn_title(rs.getString("ann_title"));
                noti.setAnn_regi(rs.getString("ann_regi"));
                noti.setAnn_check(rs.getInt("ann_check"));
                noti.setAnn_detail(rs.getString("ann_detail"));  // 공지사항 내용 추가

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
