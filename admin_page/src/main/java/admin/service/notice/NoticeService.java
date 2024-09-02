package admin.service.notice;

import java.util.List;

import admin.DAO.noti.NoticeDAO;
import admin.DTO.notice.NoticeDTO;

public class NoticeService<TodoDTO> {

    public static NoticeDTO getNoticeById(int ann_seq) {
        return noticeDAO.getNoticeById(ann_seq);
    }

        
     // DAO에서 DB로 접속, insert 해줌
        int register(TodoDTO todoDTO) {
    		// DB에 insert
    		NoticeDAO dao = new NoticeDAO();
    		return dao.insertNotice(noticeDAO);
    	}


	private static NoticeDAO noticeDAO = new NoticeDAO();

	public List<NoticeDTO> getAllNotices() {
		return noticeDAO.selectAnnounce();
	}


	// 공지사항 삭제 메서드
	public int delete (NoticeDTO NoticeDTO) {
		
		return this.noticeDAO.delete(NoticeDTO);

	}

}
