package user.dao.noti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.dto.noti.NotiDTO;

public class NotiDAO2 {

    // 페이지 크기
    private static final int PAGE_SIZE = 10;

    // 특정 페이지의 공지사항을 가져오는 메서드
    public List<NotiDTO> getNotiByPage(int currentPage, int pageSize) {
        List<NotiDTO> list = new ArrayList<>();
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;

        try {
            // DB 연결
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            // SQL 쿼리 작성 
            String query = "SELECT * FROM ("
                         + "    SELECT ROWNUM AS rnum, a.* FROM ("
                         + "        SELECT ann_seq, class, ann_title, ann_regi, ann_detail, ann_check"
                         + "        FROM announcement"
                         + "        JOIN ann_class USING(class_id)"
                         + "        ORDER BY ann_regi DESC"
                         + "    ) a"
                         + ") WHERE rnum BETWEEN ? AND ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, startRow);
            ps.setInt(2, endRow);

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

    // 총 공지사항 수를 반환하는 메서드
    public int getTotalNotiCount() {
        int count = 0;

        try {
            // DB 연결
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            // SQL 쿼리 작성
            String query = "SELECT COUNT(*) FROM announcement";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            // 리소스 정리
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}
