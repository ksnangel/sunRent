package com.rent.model;

import java.util.List;

import com.rent.dto.ProductVO;

public class ProductService {
	ProductDAO dao = new ProductDAO ();//1.서비스가 new될때 DAO도 new 되는것
	
	public List<ProductVO> selectAll() {
		return dao.selectAll();		
	}
	public ProductVO selectProductID(int product_id) {
		return dao.selectProductid(product_id);		
	}
	public ProductVO selectProductname(String  product_name) {
		return dao.selectPname(product_name);
	}
	public ProductVO selectProductsize(String  product_size) {
		return dao.selectPsize(product_size);
	}
	public ProductVO selectProductcolor(String product_color) {
		return dao.selectPcolor(product_color);
	}
	public ProductVO selectProductState(String product_State) {
		return dao.selectPstate(product_State);
	}

	
	public int insert(ProductVO product) {
		return dao.insert(product);		
	}
	public int update(ProductVO product) {
		return dao.update(product);		
	}
	public int delete(int product) {
		return dao.delete(product);		
	}

}
