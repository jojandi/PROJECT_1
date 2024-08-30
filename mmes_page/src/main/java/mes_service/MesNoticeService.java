package mes_service;

import java.util.List;

import mes_DAO.MesNoticeDAO;
import mes_DTO.MesNoticeDTO;

public class MesNoticeService {
	
	MesNoticeDAO NoticeDAO = new MesNoticeDAO();
	
	public List getNotice() {
		
		
		List result = this.NoticeDAO.selectNotice();
		
		return result;
		
	}
	
	public MesNoticeDTO get (int notice_id) {
		
		MesNoticeDTO NoticeDTO = new MesNoticeDTO();
		
		NoticeDTO = NoticeDAO.selectOne(notice_id);
		
		return NoticeDTO;
		
	}
	
	public MesNoticeDTO One(int Notice_id) {
		
		MesNoticeDTO NoticeDTO = new MesNoticeDTO();
		
		NoticeDTO = this.NoticeDAO.selectOne(Notice_id);
		
		return NoticeDTO;
	}
	
	public int insert (MesNoticeDTO NoticeDTO) {
		
		return this.NoticeDAO.insert(NoticeDTO);
		
	}
	
	public int update (MesNoticeDTO NoticeDTO) {
		
		return this.NoticeDAO.update(NoticeDTO);
		
	}
	
	public int delete (MesNoticeDTO NoticeDTO) {
		
		return this.NoticeDAO.delete(NoticeDTO);
		
	}


}
