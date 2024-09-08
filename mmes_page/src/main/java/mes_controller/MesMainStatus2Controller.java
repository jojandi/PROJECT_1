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

@WebServlet("/getDemandStatistics")
public class MesMainStatus2Controller extends HttpServlet {

    private MesMainService service;

    @Override
    public void init() throws ServletException {
        service = new MesMainService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 전달된 파라미터 확인 (연도, 월)
        String selectedYear = request.getParameter("year");
        String selectedMonth = request.getParameter("month");
        
        System.out.println("Year: " + selectedYear);
        System.out.println("Month: " + selectedMonth);

        int year = Integer.parseInt(selectedYear);
        int month = Integer.parseInt(selectedMonth);

        // 수요 통계 데이터 가져오기
        List<MesMainDTO> demandStats = service.getStatisticsByGenreForDemand(year, month);

        // 수요 데이터가 비어있는지 확인
        if (demandStats.isEmpty()) {
            System.out.println("No data found for the given year and month.");
        } else {
            System.out.println("Data found, processing...");
        }

        // JSON 데이터 생성
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for (int i = 0; i < demandStats.size(); i++) {
            MesMainDTO dto = demandStats.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"genre\":").append("\"").append(dto.getGenre()).append("\",");
            jsonBuilder.append("\"demand\":").append(dto.getDemand());
            jsonBuilder.append("}");
            if (i < demandStats.size() - 1) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]");

        // JSON 반환
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonBuilder.toString());
    }
}
