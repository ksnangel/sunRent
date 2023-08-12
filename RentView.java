package com.rent.view;

import java.util.List;

import com.rent.dto.CustomerVO;
import com.rent.dto.ProductVO;
import com.rent.dto.RentVO;

public class RentView {

	static public void print(List<RentVO> rlist) {
		System.out.println("*****************여러건 출력*****************");
		for (RentVO rent : rlist) {// rlist는 RentVO타입에 rent를 받아서
			System.out.println(rent);
		}
	}
	static public void print(RentVO rent) {
		System.out.println("*****************한건만 출력*****************");		
			System.out.println(rent);		
	}
	static public void print(String message) {
		System.out.println("***************** 알   림 *****************");		
			System.out.println(message);		
	}	
	
}
