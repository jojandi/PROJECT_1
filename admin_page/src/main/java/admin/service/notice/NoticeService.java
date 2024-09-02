package admin.service.notice;

import java.util.List;

import admin.DAO.noti.NoticeDAO;
import admin.DTO.notice.NoticeDTO;

public class NoticeService<TodoDTO> {

	private NoticeDAO noticeDAO = new NoticeDAO();

	public List<NoticeDTO> getAllNotices() {
		return noticeDAO.selectAnnounce();
	}

	public NoticeDTO getNoticeById(int ann_seq) {
		return noticeDAO.getNoticeById(ann_seq);
	}


	// 공지사항 삭제 메서드
	public boolean deleteNoticeById(int annSeq) {
		// 데이터베이스에서 공지사항을 ID로 삭제하는 로직을 여기에 구현
		// 예시:
		// boolean isDeleted = database.deleteNoticeById(annSeq);
		// return isDeleted;
		return true; // 임시로 삭제 성공 반환

	}

}
