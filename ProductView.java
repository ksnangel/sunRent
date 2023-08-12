package com.rent.view;

import java.util.List;

import com.rent.dto.CustomerVO;
import com.rent.dto.ProductVO;

public class ProductView {


		static public void print(List<ProductVO> plist) {
			System.out.println("*****************여러건 출력*****************");
			for (ProductVO product : plist) {// plist는 ProductVO타입에 product를 받아서
				System.out.println(product);
			}
		}
		static public void print(ProductVO product) {
			System.out.println("*****************한건만 출력*****************");		
				System.out.println(product);		
		}
		static public void print(String message) {
			System.out.println("***************** 알   림 *****************");		
				System.out.println(message);		
		}	
		
	}
