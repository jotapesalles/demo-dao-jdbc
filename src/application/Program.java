package application;

import java.util.List;
import java.util.Scanner;

import dao.DAOFactory;
import dao.SellerDAO;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		System.out.println("\n====== Test 4: insert ====== ");
		sellerDAO.insert(sel);
		
		System.out.println("\n====== Test 5: update ====== ");
		sel.setName("Martha Wayne");
		sellerDAO.update(sel);
		
		System.out.println("\n====== Test 6: delete ====== ");
		sellerDAO.deleteById(sc.nextInt());
		
		sc.close();
		
	}

}
