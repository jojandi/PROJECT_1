package mes_DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import mes_DTO.MesMainDTO;


public class MesMainDAO {
	public List<MesMainDTO> selectAll() {
		List<MesMainDTO> list = new ArrayList<MesMainDTO>();
		
		try {
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
		
			String query = " SELECT * from deliverystatus_total;";
				  
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
			
				
				int ds_id = rs.getInt("ds_id");
				int bom_code = rs.getInt("bom_code");
				int total_sales = rs.getInt("total_sales");
				int date_id = rs.getInt("date_id");
				
				MesMainDTO dto = new MesMainDTO();
				dto.setDs_id(ds_id);
				dto.setBom_code(bom_code);
				dto.setTotal_sales(total_sales);
				dto.setDate_id(date_id);
				
				
				
				list.add(dto);
				
				
					
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
  
}
