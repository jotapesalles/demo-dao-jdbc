package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SellerDAO;
import db.DB;
import entities.Department;
import entities.Seller;

public class SellerDAOJDBC implements SellerDAO {
	private Connection conn;
	public SellerDAOJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Seller d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller sel = instantiateSeller(rs, dep);
				return sel;
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
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
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			 st = conn.prepareStatement("SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			rs = st.executeQuery();
			
			List<Seller> sellers = new ArrayList<>();
			Seller sel;
			
			Map<Integer, Department> departmentMap = new HashMap<>();
			
			while(rs.next()) {
				Department dep = departmentMap.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					dep = instantiateDepartment(rs);
					departmentMap.put(rs.getInt("DepartmentId"),dep);
				}
					
				sel = instantiateSeller(rs, dep);
				sellers.add(sel);
			}
			return sellers;
		}
		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department dep) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			 st = conn.prepareStatement("SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			st.setInt(1, dep.getId());
			
			rs = st.executeQuery();
			
			List<Seller> sellers = new ArrayList<>();
			Seller sel;
			Department instDep = null;
			while(rs.next()) {
				if(instDep == null)
					instDep = instantiateDepartment(rs);
				sel = instantiateSeller(rs, instDep);
				sellers.add(sel);
			}
			return sellers;
		}
		
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return null;
	}
	
}
