package admin.DAO.noti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import admin.DTO.notice.NoticeDTO;

public class NoticeDAO {

	private static final Statement DBConnection = null;
	
	// db 공지사항에서 공지사항 내역을 가져와서 돌려준다
	public List selectAnnounce() {
		List list = new ArrayList();

		try {

			// 디비 접속
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx
					.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataSource.getConnection();
			// 에스큐엘 준비
			String query = "select * from announcement";
			PreparedStatement ps = con.prepareStatement(query);

			// 에스큐엘 실행
			ResultSet rs = ps.executeQuery();

			// 결과활용
			while (rs.next()) {
				NoticeDTO noticeDTO = new NoticeDTO();

				// 이번 줄에서 empno 컬럼의 값을 int로 형변환해서 가져옴
				int ann_seq = rs.getInt("ann_seq");
				noticeDTO.setAnn_seq(ann_seq);

				String class_id = rs.getString("class_id");
				noticeDTO.setClass_id(class_id);

				String ann_title = rs.getString("ann_title");
				noticeDTO.setAnn_title(ann_title);

				String ann_regi = rs.getString("ann_regi");
				noticeDTO.setAnn_regi(ann_regi);

				int ann_check = rs.getInt("ann_check");
				noticeDTO.setAnn_check(ann_check);

				String ann_detail = rs.getString("ann_detail");
				noticeDTO.setAnn_detail(ann_detail);

				String ann_attach = rs.getString("ann_attach");
				noticeDTO.setAnn_attach(ann_attach);

				list.add(noticeDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
	// 공지사항 세부 조회하는 부분
	public NoticeDTO getNoticeById(int ann_seq) {
		NoticeDTO noticeDTO = null;
		String sql = "SELECT * FROM announcement WHERE ann_seq = ?";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ann_seq);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					noticeDTO = new NoticeDTO();

					int seq = rs.getInt("ann_seq");
					noticeDTO.setAnn_seq(seq);

					String class_id = rs.getString("class_id");
					noticeDTO.setClass_id(class_id);

					String ann_title = rs.getString("ann_title");
					noticeDTO.setAnn_title(ann_title);

					String ann_regi = rs.getString("ann_regi");
					noticeDTO.setAnn_regi(ann_regi);

					int ann_check = rs.getInt("ann_check");
					noticeDTO.setAnn_check(ann_check);

					String ann_detail = rs.getString("ann_detail");
					noticeDTO.setAnn_detail(ann_detail);

					String ann_attach = rs.getString("ann_attach");
					noticeDTO.setAnn_attach(ann_attach);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeDTO;
	}

	// 공지사항 추가하는 부분
	public void insertNotice(NoticeDTO noticeDTO) {
		String sql = "INSERT INTO announcement (ann_seq, class_id, ann_title, ann_regi, ann_check, ann_detail, ann_attach) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			int ann_seq = noticeDTO.getAnn_seq();
			pstmt.setInt(1, ann_seq);

			String class_id = noticeDTO.getClass_id();
			pstmt.setString(2, class_id);

			String ann_title = noticeDTO.getAnn_title();
			pstmt.setString(3, ann_title);

			String ann_regi = noticeDTO.getAnn_regi();
			pstmt.setString(4, ann_regi);

			int ann_check = noticeDTO.getAnn_check();
			pstmt.setInt(5, ann_check);

			String ann_detail = noticeDTO.getAnn_detail();
			pstmt.setString(6, ann_detail);

			String ann_attach = noticeDTO.getAnn_attach();
			pstmt.setString(7, ann_attach);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
}
