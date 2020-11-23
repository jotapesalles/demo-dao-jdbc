package application;

import dao.DAOFactory;
import dao.DepartmentDAO;
import entities.Department;

public class ProgramDep {

	public static void main(String[] args) {
		DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
		Department dep = new Department(null, "Food");
		System.out.println("====== Test 1: insert =====");
		departmentDAO.insert(dep);
		

	}

}
