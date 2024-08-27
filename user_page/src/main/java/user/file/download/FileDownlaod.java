package user.file.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownlaod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	      
//		String fileName = "cat.png";
		String fileName = request.getParameter("fileName");
		File downFile = new File("C:\\temp\\upload\\" + fileName); // 다운로드 받을 파일
		
		// 브라우저 캐시를 사용하지 않도록 설정
		response.setHeader("Cache-Control", "no-cache");
		// 응답이 첨부파일이라는 것을 알려줌 ( attachment : 첨부파일 )
        response.addHeader("Content-disposition", "attachment; fileName="+ fileName);
        
        // 파일을 읽는 흐름 열기
        FileInputStream fis = new FileInputStream(downFile);
        // java 메모리로 가져올 상자 크기 설정
        byte[] buf = new byte[1024 * 1]; // 보통 8kbyte 사용
        
        // 최종적으로 파일을 담아 브라우저로 보낼 것
        OutputStream os = response.getOutputStream();
        
        while(true) {
        	// 파일에서 상자 크기만큼 읽어서 상자에 담기
        	// 읽은만큼 돌려줌 ( 읽을 게 없다면 -1 돌려줌 )
        	int count = fis.read(buf);
        	
        	// 읽을게 없을 때 반복문 종료
        	if(count == -1) {
        		break;
        	}
        	// buf를 처음부터 count만큼까지( 읽은만큼 ) 브라우저로 내보내기
        	os.write(buf, 0, count);
        }
        
        os.close();
        fis.close();
        
	}

}
