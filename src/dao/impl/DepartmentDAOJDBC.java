package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.DepartmentDAO;
import db.DB;
import entities.Department;
import entities.Seller;

public class DepartmentDAOJDBC implements DepartmentDAO {
	private Connection conn;
	
	public DepartmentDAOJDBC(Connection conn) {
		this.conn = conn;
	}
	
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller sel = new Seller();
		sel.setId(rs.getInt("Id"));
		sel.setName(rs.getString("Name"));
		sel.setEmail(rs.getString("Email"));
		sel.setBaseSalary(rs.getDouble("BaseSalary"));
		sel.setBirthDate(rs.getDate("BirthDate"));
		sel.setDepartment(dep);
		return sel;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException{
		Department dep = new 
		Department(rs.getInt("DepartmentId"),rs.getString("DepName"));
		return dep;
	}

	@Override
	public void insert(Department d) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("INSERT INTO department"
					+ "(Name) VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, d.getName());
			int rowsAffected = st.executeUpdate();
			rs = st.getGeneratedKeys();
			if(rs.next()) d.setId(rs.getInt(1));
			System.out.println("Done! Rows Affected: "+ rowsAffected);
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void update(Department d) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ?");
			st.setString(1, d.getName());
			st.setInt(2, d.getId());
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows Affected: "+ rowsAffected);
			System.out.println(d);
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
