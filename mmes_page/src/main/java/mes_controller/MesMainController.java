package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesMainDTO;
import mes_service.MesMainService;

@WebServlet("/main")
public class  MesMainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
   
        request.getRequestDispatcher("/WEB-INF/mes/mes_main/mes_main.jsp").forward(request, response);
    }
}


