package com.rent.model;

import java.sql.SQLException;
import java.util.List;

import com.rent.dto.CustomerVO;

//DAO 함수들을 복사해서 Service로 가져와서 붙여넣는다.  ==> Controller와 DAO 사이에서 함수로 중간다리연결만 하면 된다.

public class CustomerService {
	// Service가 new될때  dao가 new 되는거다
	//(함수 추가나, 시그니쳐가 바뀌지 않으면)//Service가 new될때 dao가 new 되는거다		
	CustomerDAO dao = new CustomerDAO();

	// List타입(BoardVO형태) 전체조회
	public List<CustomerVO> selectAll() {

		return dao.selectAll();
	}

	public CustomerVO selectByid(int cust_id) {

		return dao.selectByid(cust_id);
	}
	public CustomerVO selectname(String cust_name) {
		return dao.selectname(cust_name);
	}
	/*
	public List<CustomerVO> selectBynames(String bynames) {
		// 로직을 작성하진 않았으니 일단 null로 해놓는다.
		return dao.selectBynames(bynames);
	} */

	// insert 건수 무슨타입에 무엇을 몇건 삽입해라
	public int insert(CustomerVO customer)  {
		// 리턴 건수를 CustomerVO타입의 rent로 (일단 0으로 해놓는다)
		return dao.insert(customer);
	}

	// update 건수 무슨타입에 무엇을 수정해라
	public int update(CustomerVO customer) {
		// 리턴 건수를 CustomerVO타입의 rent로 (일단 0으로 해놓는다)
		return dao.update(customer);
	}

	// delete 건수 무슨타입에 무엇을 삭제해라
	public int delete(int cust_id) {
		// 리턴 건수를 int타입의 cust_id(고객번호)로 (일단 0으로 해놓는다)
		return dao.delete(cust_id);
	}

}
