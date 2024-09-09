package admin.service.main;

import java.util.List;

import admin.DAO.main.MainDAO;
import admin.DTO.notice.NoticeDTO;

public class MainService {
	
	public List<NoticeDTO> notiList(){
		return new MainDAO().notiList();
	}
}
