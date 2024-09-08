package mes_controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesMainDTO;
import mes_service.MesMainService;

import java.io.IOException;
import java.util.List;

@WebServlet("/getBookStatistics")
public class MesMainStatus1Controller extends HttpServlet {
    
    private MesMainService mesMainService;

    @Override
    public void init() throws ServletException {
        mesMainService = new MesMainService();  // 서비스 객체 생성
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedYear = request.getParameter("year");
        String selectedMonth = request.getParameter("month");
        Integer year = Integer.parseInt(selectedYear);
        Integer month = Integer.parseInt(selectedMonth);

        // 서비스에서 연도와 월에 맞는 데이터를 장르별로 가져옴
       
        List<MesMainDTO> statistics = mesMainService.getStatisticsByGenre(year, month);

        // JSON 문자열 생성
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");  // JSON 배열 시작

        for (int i = 0; i < statistics.size(); i++) {
            MesMainDTO dto = statistics.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"genre\":").append("\"").append(dto.getGenre()).append("\",");
            jsonBuilder.append("\"total\":").append(dto.getTotal());
            jsonBuilder.append("}");
            
            // 마지막 요소가 아닌 경우 쉼표 추가
            if (i < statistics.size() - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("]");  // JSON 배열 끝

        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonBuilder.toString());
    }
}