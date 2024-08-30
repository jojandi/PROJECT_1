package admin.DAO.notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import admin.DTO.notice.NoticeDTO;

public class NoticeDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private Connection getConnection() {
		
		Connection con = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
		String user = "scott2_0";
		String password = "tiger";
    }
    // 공지사항 추가(Create)
    public void addNotice(NoticeDTO notice) throws SQLException {
        String sql = "INSERT INTO notices (category, title, date, content) VALUES (?, ?, ?, ?)";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, notice.getCategory());
            pstmt.setString(2, notice.getTitle());
            pstmt.setString(3, notice.getDate());
            pstmt.setString(4, notice.getContent());
            pstmt.executeUpdate();
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
		// TODO Auto-generated method stub
		
	}
	// 공지사항 목록 조회(Read)
    public List<NoticeDAO> getAllNotices() throws SQLException {
        List<NoticeDAO> noticeList = new ArrayList<>();
        String sql = "SELECT * FROM notices";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                NoticeDAO notice = new NoticeDAO(
                );
                noticeList.add(notice);
            }
        } finally {
            closeResources();
        }
        return noticeList;
    }

    // 특정 공지사항 조회(Read by ID)
    public NoticeDAO getNoticeById(int id) throws SQLException {
        NoticeDAO notice = null;
        String sql = "SELECT * FROM notices WHERE id = ?";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                notice = new NoticeDAO(
                );
            }
        } finally {
            closeResources();
        }
        return notice;
    }

    // 공지사항 수정(Update)
    public void updateNotice(NoticeDAO notice) throws SQLException {
        String sql = "UPDATE notices SET category = ?, title = ?, date = ?, content = ? WHERE id = ?";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, notice.getCategory());
            pstmt.setString(2, notice.getTitle());
            pstmt.setString(3, notice.getTitle());
            pstmt.setString(4, notice.getContent());
            pstmt.setInt(5, notice.getId());
            pstmt.executeUpdate();
        } finally {
            closeResources();
        }
    }

    private int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	private String getContent() {
		// TODO Auto-generated method stub
		return null;
	}
	private String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	private String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	// 공지사항 삭제(Delete)
    public void deleteNotice(int id) throws SQLException {
        String sql = "DELETE FROM notices WHERE id = ?";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } finally {
            closeResources();
        }
    }

		
	}

    
   
