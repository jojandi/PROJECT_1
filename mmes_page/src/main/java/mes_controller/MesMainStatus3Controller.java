package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesMainDTO;
import mes_service.MesMainService;

@WebServlet("/demandForecast")
public class MesMainStatus3Controller extends HttpServlet {
    private MesMainService mesmainService;

    @Override
    public void init() throws ServletException {
        mesmainService = new MesMainService();  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedYear = request.getParameter("year");
        String selectedMonth = request.getParameter("month");

        if (selectedYear == null || selectedMonth == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Year or month is missing.");
            return;
        }

        // 연도와 월을 합쳐서 202401 같은 형식으로 변환
        int formattedDate = Integer.parseInt(selectedYear) * 100 + Integer.parseInt(selectedMonth);

        List<MesMainDTO> forecastList = mesmainService.getForecastData(formattedDate);

        if (forecastList.isEmpty()) {
            System.out.println("No forecast data for the selected month.");
        } else {
            System.out.println("Forecast data size: " + forecastList.size());
        }

        // 데이터를 JSON으로 변환하여 반환
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for (int i = 0; i < forecastList.size(); i++) {
            MesMainDTO dto = forecastList.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"genre\":\"").append(dto.getGenre()).append("\",");
            jsonBuilder.append("\"expectedDemand\":").append(dto.getExpectedDemand());
            jsonBuilder.append("}");
            if (i < forecastList.size() - 1) {
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]");
        response.getWriter().write(jsonBuilder.toString());
    }
    
}