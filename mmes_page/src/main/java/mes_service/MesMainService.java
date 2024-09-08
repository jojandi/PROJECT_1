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
    
    public List<MesMainDTO> getStatisticsByGenreForDemand(int year, int month) {
        // 연도와 월을 전달할 때 로그 남기기
        System.out.println("Service - Year: " + year + ", Month: " + month);
        List<MesMainDTO> result = mesMainDAO.getStatisticsByGenreForDemand(year, month);
        
        if (result.isEmpty()) {
            System.out.println("Service - No data returned from DAO");
        } else {
            System.out.println("Service - Data returned from DAO");
        }
        return result;
    }
    
  
    public List<MesMainDTO> getForecastData(int formattedDate) {
        // formattedDate는 YYYYMM 형식이므로, 연도와 월을 분리
        int year = formattedDate / 100;  // 연도 추출 (예: 202401 -> 2024)
        int month = formattedDate % 100;  // 월 추출 (예: 202401 -> 01)

        // 연도와 월을 getForecastStatisticsByGenre 메서드에 전달
        return mesMainDAO.getForecastStatisticsByGenre(year, month);
    }
}