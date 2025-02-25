package mes_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mes_DTO.MesHumanDTO;









public class MesHumanDAO {
	
	public List<MesHumanDTO> selectAll() {
		List<MesHumanDTO> list = new ArrayList<MesHumanDTO>();
		
		try {
			
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection con = dataSource.getConnection();
		
			String query = " SELECT e.emp_id, e.emp_name, p.po_name, d.dept_name, e.emp_hp, e.emp_add, e.emp_hiredate";
				   query +=" FROM employee e";
				   query +=" JOIN department d ON e.dept_id = d.dept_id";
				   query +=" JOIN tbl_position p ON e.po_id = p.po_id";
				   query +=" ORDER by emp_id ";
				   
		
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
			
				
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String po_name = rs.getString("po_name");
				String dept_name = rs.getString("dept_name");
				String emp_hp = rs.getString("emp_hp");
				String emp_add = rs.getString("emp_add");
				Date emp_hiredate = rs.getDate("emp_hiredate");
				
				MesHumanDTO dto = new MesHumanDTO();
				dto.setEmp_id(emp_id);
				dto.setEmp_name(emp_name);
				dto.setPo_name(po_name);
				dto.setDept_name(dept_name);
				dto.setEmp_hp(emp_hp);
				dto.setEmp_add(emp_add);
				dto.setEmp_hiredate(emp_hiredate);
				
				
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
	
	public int insert(MesHumanDTO dto) {
		int result = -1;
		
		try {
			
			// Servers 폴더의 context.xml에서
			// name이 jdbc/oracle인 resource를 가져와서 DataSource로 저장하기
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB 접속 : 커넥션풀을 사용해서 
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "INSERT INTO employee (emp_id, emp_name, dept_id, po_id, emp_hp, emp_add, emp_hiredate) ";
			query += "SELECT emp_seq.nextval, ?, d.dept_id, p.po_id, ?, ?, ? ";
			query += "FROM department d, tbl_position p ";
			query += "WHERE d.dept_name = ? AND p.po_name = ?";
		
			   
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getEmp_name());
			ps.setString(2, dto.getEmp_hp());
			ps.setString(3, dto.getEmp_add());
			ps.setDate(4, dto.getEmp_hiredate());
			ps.setString(5, dto.getDept_name());
			ps.setString(6, dto.getPo_name());
			
			
			
			// SQL 실행
			result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public MesHumanDTO selectOne(int emp_id) {
		MesHumanDTO empDTO = null;
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			
			String query = " SELECT e.emp_id, e.emp_name, p.po_name, d.dept_name, e.emp_hp, e.emp_add, e.emp_hiredate";
			   query +=" FROM employee e";
			   query +=" JOIN department d ON e.dept_id = d.dept_id";
			   query +=" JOIN tbl_position p ON e.po_id = p.po_id";
			   query +=" WHERE emp_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			
		
			ps.setInt(1, emp_id);
			System.out.println(emp_id);
			// SQL 실행
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				empDTO = new MesHumanDTO();
				empDTO.setEmp_id(rs.getInt("emp_id") );
				empDTO.setEmp_name(rs.getString("emp_name") );
				empDTO.setEmp_hp(rs.getString("emp_hp") );
				empDTO.setEmp_add(rs.getString("emp_add") );
				empDTO.setEmp_hiredate(rs.getDate("emp_hiredate") );
				empDTO.setDept_name(rs.getString("dept_name") );
				empDTO.setPo_name(rs.getString("po_name") );
			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return empDTO;
	}
	public int deleteOne(int emp_id) {
		int result = -1;
		
		try {
			// DB 접속
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "delete from employee where emp_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, emp_id);
			System.out.println(emp_id);
			// SQL 실행
			result = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int updateOne(MesHumanDTO dto) {
		int result = -1;
		
		try {
			
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			// DB 접속 : 커넥션풀을 사용해서 
			Connection con = dataFactory.getConnection();
			
			// SQL 준비
			String query = "UPDATE employee e ";
			query += "SET e.emp_name = ?, ";
			query += "    e.dept_id = (SELECT d.dept_id FROM department d WHERE d.dept_name = ?), ";
			query += "    e.po_id = (SELECT p.po_id FROM tbl_position p WHERE p.po_name = ?), ";
			query += "    e.emp_hp = ?, ";
			query += "    e.emp_add = ?, ";
			query += "    e.emp_hiredate = ? ";
			query += "WHERE e.emp_id = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, dto.getEmp_name());
			ps.setString(2, dto.getDept_name());
			ps.setString(3, dto.getPo_name());
			ps.setString(4, dto.getEmp_hp());
			ps.setString(5, dto.getEmp_add());
			ps.setDate(6, dto.getEmp_hiredate());
			ps.setInt(7, dto.getEmp_id());
			// SQL 실행
			result = ps.executeUpdate();
			
			ps.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

