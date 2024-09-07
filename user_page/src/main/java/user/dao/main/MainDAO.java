package user.dao.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.noti.NotiDTO;

public class MainDAO {
	
	// 특정 페이지의 공지사항을 가져오는 메서드
    public List<NotiDTO> notiList() {
        List<NotiDTO> list = new ArrayList<>();

        try {
            // DB 연결
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            
            // SQL 쿼리 작성 
            String query = " select * from announcement join ann_class using(class_id) ";
            query += " where rownum >=1 and rownum <= 3 order by ann_seq desc ";
            
            PreparedStatement ps = con.prepareStatement(query);

            // SQL 실행 및 결과 획득
            ResultSet rs = ps.executeQuery();

            // 결과 처리
            while (rs.next()) {
                NotiDTO noti = new NotiDTO();
                noti.setAnn_Seq(rs.getInt("ann_seq"));
                noti.setClass_name(rs.getString("class"));
                noti.setAnn_Title(rs.getString("ann_title"));
                noti.setAnn_Regi(rs.getString("ann_regi"));
                noti.setAnn_Check(rs.getInt("ann_check"));
                noti.setAnn_Detail(rs.getString("ann_detail"));  // 공지사항 내용 추가

                // 리스트에 추가
                list.add(noti);
            }

            // 리소스 정리
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
	
}
