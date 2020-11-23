package dao;

import dao.impl.DepartmentDAOJDBC;
import dao.impl.SellerDAOJDBC;
import db.DB;

public class DAOFactory {
	public static SellerDAO createSellerDAO() {
		return new SellerDAOJDBC(DB.getConnection());
	}
	
	public static DepartmentDAO createDepartmentDAO() {
		return new DepartmentDAOJDBC(DB.getConnection());
	}
}
