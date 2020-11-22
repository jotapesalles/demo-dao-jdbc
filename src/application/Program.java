package application;

import dao.DAOFactory;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");
		Seller sel = new Seller(21, "Bob", "bob@gmail.com", "25/05/1998", 3000.0, obj );
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		System.out.println(obj);
		System.out.println(sel);
	}

}
