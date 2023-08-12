package com.rent.model;

import java.sql.SQLException;
import java.util.List;

import com.rent.dto.CustomerVO;

//DAO �Լ����� �����ؼ� Service�� �����ͼ� �ٿ��ִ´�.  ==> Controller�� DAO ���̿��� �Լ��� �߰��ٸ����Ḹ �ϸ� �ȴ�.

public class CustomerService {
	// Service�� new�ɶ�  dao�� new �Ǵ°Ŵ�
	//(�Լ� �߰���, �ñ״��İ� �ٲ��� ������)//Service�� new�ɶ� dao�� new �Ǵ°Ŵ�		
	CustomerDAO dao = new CustomerDAO();

	// ListŸ��(BoardVO����) ��ü��ȸ
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
		// ������ �ۼ����� �ʾ����� �ϴ� null�� �س��´�.
		return dao.selectBynames(bynames);
	} */

	// insert �Ǽ� ����Ÿ�Կ� ������ ��� �����ض�
	public int insert(CustomerVO customer)  {
		// ���� �Ǽ��� CustomerVOŸ���� rent�� (�ϴ� 0���� �س��´�)
		return dao.insert(customer);
	}

	// update �Ǽ� ����Ÿ�Կ� ������ �����ض�
	public int update(CustomerVO customer) {
		// ���� �Ǽ��� CustomerVOŸ���� rent�� (�ϴ� 0���� �س��´�)
		return dao.update(customer);
	}

	// delete �Ǽ� ����Ÿ�Կ� ������ �����ض�
	public int delete(int cust_id) {
		// ���� �Ǽ��� intŸ���� cust_id(����ȣ)�� (�ϴ� 0���� �س��´�)
		return dao.delete(cust_id);
	}

}
