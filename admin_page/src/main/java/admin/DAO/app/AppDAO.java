package admin.DAO.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import admin.DAO.inven.LoggableStatement;
import admin.DTO.app.AppDTO;

public class AppDAO {

    // 특정 도서 신청 정보 조회 (전체 또는 특정 신청 번호에 해당하는 데이터)
    public List<AppDTO> selectApp(String ann_seq) {
        List<AppDTO> list = new ArrayList<>();

        try {
            // DB 접속
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            // SQL 준비
            String query;
            PreparedStatement ps;

            if (ann_seq == null) {
                query = "SELECT * FROM app_table";
                ps = con.prepareStatement(query);
            } else {
                query = "SELECT * FROM app_table WHERE ann_seq = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(ann_seq));
            }

            // SQL 실행 및 결과 확보
            ResultSet rs = ps.executeQuery();

            // 결과 활용
            while (rs.next()) {
                AppDTO appDTO = new AppDTO();
                appDTO.setAnn_seq(rs.getInt("ann_seq"));
                appDTO.setApp_book(rs.getString("app_book"));
                appDTO.setApp_name(rs.getString("app_name"));
                appDTO.setApp_pub(rs.getString("app_pub"));
                appDTO.setApp_date(rs.getInt("app_date"));
                appDTO.setUser_seq(rs.getString("user_seq"));

                list.add(appDTO);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 도서 신청 정보 삽입
    public int insertApp(AppDTO dto) {
        int result = -1;

        try {
            // DB 접속
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
            Connection con = dataSource.getConnection();

            // SQL 준비
            String query = "INSERT INTO app_table (ann_seq, app_book, app_name, app_pub, app_date, user_seq) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = new LoggableStatement(con, query);

            ps.setInt(1, dto.getAnn_seq());
            ps.setString(2, dto.getApp_book());
            ps.setString(3, dto.getApp_name());
            ps.setString(4, dto.getApp_pub());
            ps.setLong(5, dto.getApp_date());
            ps.setString(6, dto.getUser_seq());

            // 실제 실행되는 SQL 출력
            System.out.println(((LoggableStatement) ps).getQueryString());

            // SQL 실행
            result = ps.executeUpdate();

            // 자원 해제
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

   
}
