package application;

import dao.DAOFactory;
import dao.SellerDAO;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
		


		SellerDAO sellerDAO = DAOFactory.createSellerDAO();	
		Seller sel = sellerDAO.findById(3);
		System.out.println(sel);
	}

}
