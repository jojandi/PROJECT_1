package mes_service;

import java.util.List;
import mes_DAO.MesMainDAO;
import mes_DTO.MesMainDTO;

public class MesMainService {
    
    private MesMainDAO mesMainDAO;

    // 서비스 생성자에서 DAO 초기화
    public MesMainService() {
        this.mesMainDAO = new MesMainDAO();
    }

    // 월별 출고 통계 데이터를 가져오는 메서드
    public List<MesMainDTO> getStatisticsByGenre(Integer year, Integer month) {
        // 연도와 월에 맞는 장르별 출고 데이터를 가져오는 DAO 메서드 호출
        return mesMainDAO.getStatisticsByGenre(year, month);
    }

}