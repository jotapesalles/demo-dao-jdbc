package dao.impl;

import java.sql.Connection;
import java.util.List;

import dao.DepartmentDAO;
import entities.Department;

public class DepartmentDAOJDBC implements DepartmentDAO {
	private Connection conn;
	
	public DepartmentDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department d) {
		// TODO Auto-generated method stub
		
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
