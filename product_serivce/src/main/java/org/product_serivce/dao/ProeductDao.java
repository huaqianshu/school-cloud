package org.product_serivce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.base.entity.Product;


public interface ProeductDao extends JpaRepository<Product,Long>{
	Product findByName(String name);
	List<Product> findAll();
	Product save(Product p);

}
