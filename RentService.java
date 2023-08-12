package com.rent.model;

import java.util.List;

import com.rent.dto.RentVO;

public class RentService {//비지니스 로직을 만든다
	RentDAO dao = new RentDAO();//1.서비스가 new될때 DAO도 new 되는것
	public List<RentVO> selectAll() {
		return dao.selectAll();		
	}
	public RentVO selectRentID(int rent_id) {
		return dao.selectRentID(rent_id);		
	}
	public RentVO selectCustID(int cust_id) {
		return dao.selectCustID(cust_id);
	}
	public RentVO selectProductID(int product_id) {
		return dao.selectProductID(product_id);
	}
	public List<RentVO> selectRentDate(String rent_date) {
		return dao.selectRentDate(rent_date);
	}
	public List<RentVO> selectReturnDate(String return_date) {
		return dao.selectReturnDate(return_date);
	}

	
	public int insert(RentVO rent) {
		return dao.insert(rent);		
	}
	public int update(RentVO rent, String job) {
		return dao.update(rent, job);		
	}

	public int delete(int cust_id) {
		
		return dao.delete(cust_id);
	}
	
}
