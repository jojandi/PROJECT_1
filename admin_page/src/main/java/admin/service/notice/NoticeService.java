package admin.service.notice;

import java.util.List;

import admin.DAO.noti.NoticeDAO;
import admin.DTO.notice.NoticeDTO;

public class NoticeService {

    private NoticeDAO noticeDAO = new NoticeDAO();

    public List<NoticeDTO> getAllNotices() {
        return noticeDAO.selectAnnounce();
    }

    public NoticeDTO getNoticeById(int ann_seq) {
        return noticeDAO.getNoticeById(ann_seq);
    }

    public void addNotice(NoticeDTO noticeDTO) {
        noticeDAO.insertNotice(noticeDTO);
    }
}
