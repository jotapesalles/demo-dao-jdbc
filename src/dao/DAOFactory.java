package dao;

import dao.impl.SellerDAOJDBC;
import db.DB;

public class DAOFactory {
	public static SellerDAO createSellerDAO() {
		return new SellerDAOJDBC(DB.getConnection());
	}
}
