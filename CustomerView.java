package com.rent.view;

import java.util.List;

import com.rent.dto.CustomerVO;

public class CustomerView {

	static public void print(List<CustomerVO> clist) {
		System.out.println("*****************여러건 출력*****************");
		for (CustomerVO customer : clist) {// clist는 CustomerVO타입에 customer를 받아서
			System.out.println(customer);
		}
	}
	static public void print(CustomerVO customer) {
		System.out.println("*****************한건만 출력*****************");		
			System.out.println(customer);		
	}
	static public void print(String message) {
		System.out.println("***************** 알   림 *****************");		
			System.out.println(message);		
	}	
	
}
