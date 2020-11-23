package application;

import java.util.List;

import dao.DAOFactory;
import dao.SellerDAO;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
	
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();	
		System.out.println("====== Test 1: findById ====== ");
		Seller sel = sellerDAO.findById(3);
		System.out.println(sel);
		System.out.println("\n====== Test 2: findByDepartment ====== ");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(dep);
		for(Seller s : list) {
			System.out.println(s);
		}
		System.out.println("\n====== Test 3: findAll ====== ");
		list = sellerDAO.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		System.out.println("\n====== Test 4: findAll ====== ");
		Seller newSel = new Seller(null, "Greg","greg@gmail.com", "20/01/1990", 4000.0, dep);
		sellerDAO.insert(newSel);
		System.out.println("Inserted! New id = "+ newSel.getId());
	}

}
