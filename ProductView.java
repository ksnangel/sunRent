package com.rent.view;

import java.util.List;

import com.rent.dto.CustomerVO;
import com.rent.dto.ProductVO;

public class ProductView {


		static public void print(List<ProductVO> plist) {
			System.out.println("*****************������ ���*****************");
			for (ProductVO product : plist) {// plist�� ProductVOŸ�Կ� product�� �޾Ƽ�
				System.out.println(product);
			}
		}
		static public void print(ProductVO product) {
			System.out.println("*****************�ѰǸ� ���*****************");		
				System.out.println(product);		
		}
		static public void print(String message) {
			System.out.println("***************** ��   �� *****************");		
				System.out.println(message);		
		}	
		
	}
