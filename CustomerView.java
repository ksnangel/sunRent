package com.rent.view;

import java.util.List;

import com.rent.dto.CustomerVO;

public class CustomerView {

	static public void print(List<CustomerVO> clist) {
		System.out.println("*****************������ ���*****************");
		for (CustomerVO customer : clist) {// clist�� CustomerVOŸ�Կ� customer�� �޾Ƽ�
			System.out.println(customer);
		}
	}
	static public void print(CustomerVO customer) {
		System.out.println("*****************�ѰǸ� ���*****************");		
			System.out.println(customer);		
	}
	static public void print(String message) {
		System.out.println("***************** ��   �� *****************");		
			System.out.println(message);		
	}	
	
}
