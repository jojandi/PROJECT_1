package admin.service.notice;

import java.util.List;

import admin.DAO.noti.NoticeDAO;
import admin.DTO.notice.NoticeDTO;

public class NoticeService {

    private NoticeDAO noticeDAO;

    public NoticeService() {
        this.noticeDAO = new NoticeDAO();
    }

    // 공지사항 목록 조회 서비스
    public List<NoticeDTO> getAllNotices() {
        List<NoticeDTO> notices = noticeDAO.selectAnnounce();
        return notices;
    }

    // 공지사항 세부 조회 서비스
    public NoticeDTO getNoticeById(int ann_seq) {
        NoticeDTO notice = noticeDAO.getNoticeById(ann_seq);
        return notice;
    }

    // 공지사항 추가 서비스
    public void addNotice(NoticeDTO noticeDTO) {
        noticeDAO.insertNotice(noticeDTO);
    }

	public static List<NoticeDTO> getEmp() {
		// TODO Auto-generated method stub
		return null;
	}
}