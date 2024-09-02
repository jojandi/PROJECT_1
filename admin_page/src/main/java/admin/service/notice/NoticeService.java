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
	public int delete (NoticeDTO NoticeDTO) {
		
		return this.noticeDAO.delete(NoticeDTO);

	}

}
