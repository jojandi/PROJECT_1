package user.service.main;

import java.util.List;

import user.dao.main.MainDAO;
import user.dto.noti.NotiDTO;

public class MainService {
	
	public List<NotiDTO> notiList(){
		return new MainDAO().notiList();
	}
}
