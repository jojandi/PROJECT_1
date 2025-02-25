package admin.DAO.noti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import admin.DTO.notice.NoticeDTO;

public class NoticeDAO {

	// DB 연결을 위한 메서드
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource dataSource = (DataSource) ctx
				.lookup("java:/comp/env/jdbc/oracle");
		return dataSource.getConnection();
	}

	// 공지사항 목록 조회 메서드
	public List<NoticeDTO> selectAnnounce() {
		List list = new ArrayList();
		String query = "SELECT * FROM announcement";

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				NoticeDTO noticeDTO = new NoticeDTO();

				noticeDTO.setAnn_seq(rs.getInt("ann_seq"));
				noticeDTO.setClass_id(rs.getString("class_id"));
				noticeDTO.setAnn_title(rs.getString("ann_title"));
				noticeDTO.setAnn_regi(rs.getString("ann_regi"));
				noticeDTO.setAnn_check(rs.getInt("ann_check"));
				noticeDTO.setAnn_detail(rs.getString("ann_detail"));
				noticeDTO.setAnn_attach(rs.getString("ann_attach"));

				list.add(noticeDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 공지사항 세부 조회 메서드
	public NoticeDTO getNoticeById(int ann_seq) {
		NoticeDTO noticeDTO = null;
		String sql = "SELECT * FROM announcement WHERE ann_seq = ?";

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ann_seq);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					noticeDTO = new NoticeDTO();

					noticeDTO.setAnn_seq(rs.getInt("ann_seq"));
					noticeDTO.setClass_id(rs.getString("class_id"));
					noticeDTO.setAnn_title(rs.getString("ann_title"));
					noticeDTO.setAnn_regi(rs.getString("ann_regi"));
					noticeDTO.setAnn_check(rs.getInt("ann_check"));
					noticeDTO.setAnn_detail(rs.getString("ann_detail"));
					noticeDTO.setAnn_attach(rs.getString("ann_attach"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeDTO;
	}

	// 공지사항 추가 메서드
	public void insertNotice(NoticeDTO noticeDTO) {
		System.out.println(noticeDTO.getClass_id());
	    String sql = "INSERT INTO announcement (ann_seq,class_id, ann_title, ann_regi, ann_check, ann_detail, ann_attach) "
	               + "VALUES (ann_seq.nextval,?, ?, sysdate, ?, ?, ?)";

	    try (Connection conn = getConnection();
//	    		PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    		PreparedStatement pstmt = new LoggableStatement(conn, sql)) {

//	        pstmt.setInt(1, noticeDTO.getAnn_seq());             
	        pstmt.setInt(1, Integer.parseInt(noticeDTO.getClass_id()));        
	        pstmt.setString(2, noticeDTO.getAnn_title());      
//	        pstmt.setString(3, noticeDTO.getAnn_regi());      
	        pstmt.setInt(3, noticeDTO.getAnn_check());           
	        pstmt.setString(4, noticeDTO.getAnn_detail());       
	        pstmt.setString(5, noticeDTO.getAnn_attach());       

	        System.out.println( ( (LoggableStatement)pstmt ).getQueryString() );
	        pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public int delete(NoticeDTO noticeDTO) {
		int result = -1;

		try {

			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx
					.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();

			// SQL 준비
			String query = " delete from announcement where ann_seq = ?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, noticeDTO.getAnn_seq());

			// SQL 실행
			result = ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
