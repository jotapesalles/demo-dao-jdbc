package application;

import java.util.Scanner;

import dao.DAOFactory;
import dao.DepartmentDAO;
import entities.Department;

public class ProgramDep {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
		Department dep = new Department(null, "Food");
		
		System.out.println("====== Test 1: insert =====");
		departmentDAO.insert(dep);
		
		System.out.println("====== Test 2: update =====");
		dep.setName("Human Resources");
		departmentDAO.update(dep);
		
		System.out.println("====== Test 3: update =====");
		departmentDAO.deleteById(sc.nextInt());
		
		sc.close();
	}

}
