package com.rent.view;

import java.util.List;

import com.rent.dto.CustomerVO;
import com.rent.dto.ProductVO;
import com.rent.dto.RentVO;

public class RentView {

	static public void print(List<RentVO> rlist) {
		System.out.println("*****************������ ���*****************");
		for (RentVO rent : rlist) {// rlist�� RentVOŸ�Կ� rent�� �޾Ƽ�
			System.out.println(rent);
		}
	}
	static public void print(RentVO rent) {
		System.out.println("*****************�ѰǸ� ���*****************");		
			System.out.println(rent);		
	}
	static public void print(String message) {
		System.out.println("***************** ��   �� *****************");		
			System.out.println(message);		
	}	
	
}
