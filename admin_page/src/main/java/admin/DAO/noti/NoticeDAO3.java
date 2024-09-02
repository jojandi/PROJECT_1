package admin.DAO.noti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import admin.DTO.notice.NoticeDTO;

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
    
}
