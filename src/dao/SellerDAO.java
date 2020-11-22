package dao;

import java.util.List;

import entities.Seller;

public interface SellerDAO {
	void insert(Seller d);
	void update(Seller d);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
}
