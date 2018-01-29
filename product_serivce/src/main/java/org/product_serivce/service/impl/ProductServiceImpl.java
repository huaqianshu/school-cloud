package org.product_serivce.service.impl;

import org.product_serivce.dao.ProeductDao;
import org.product_serivce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import com.school.base.entity.Product;
import com.school.base.messanger.Result;

public class ProductServiceImpl implements  ProductService{
	@Autowired
	private ProeductDao proeductDao;
	@Override
	public Result saveProduct(Product p) {
		// TODO Auto-generated method stub
		proeductDao.save(p);
		return new Result(0,"success");
	}

}
