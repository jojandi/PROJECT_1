package admin.service.notice;

import java.util.List;

import admin.DAO.noti.NoticeDAO;
import admin.DTO.notice.NoticeDTO;

public class NoticeService<TodoDTO> {

<<<<<<< HEAD
    private static NoticeDAO noticeDAO = new NoticeDAO();



    public static NoticeDTO getNoticeById(int ann_seq) {
        return noticeDAO.getNoticeById(ann_seq);
    }

        
     // DAO에서 DB로 접속, insert 해줌
        int register(TodoDTO todoDTO) {
    		// DB에 insert
    		NoticeDAO dao = new NoticeDAO();
    		return dao.insertNotice(noticeDAO);
    	}

		public static void updateNotice(NoticeDTO updatedNotice) {
			// TODO Auto-generated method stub
			
		}


		public static List<NoticeDTO> getAllNotices() {
			// TODO Auto-generated method stub
			return null;
		}
        
        
    }
=======
	private NoticeDAO noticeDAO = new NoticeDAO();

	public List<NoticeDTO> getAllNotices() {
		return noticeDAO.selectAnnounce();
	}

	public NoticeDTO getNoticeById(int ann_seq) {
		return noticeDAO.getNoticeById(ann_seq);
	}

>>>>>>> 452ea8c769d96c5395bede0953f63ec096bcf303

	// 공지사항 삭제 메서드
	public int delete (NoticeDTO NoticeDTO) {
		
		return this.noticeDAO.delete(NoticeDTO);

	}

}
