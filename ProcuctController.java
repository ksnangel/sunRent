package com.rent.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.rent.dto.ProductVO;
import com.rent.model.ProductService;
import com.rent.model.RentService;




public class ProcuctController {

	static ProductService service = new ProductService();
	static Scanner sc = new Scanner (System.in);
	
	static Date now = new Date();
	static Calendar cal = Calendar.getInstance(); 
	static boolean flag=true;
	public static void main(String[] args) {
		
		while (flag) {
			String selectNO = menu();
			switch  (selectNO) {
			case "1": f1(); break;
			//case "2": f2(); break;
		
			case "exit": flag = false; break;
			
			default:
				break;
			
			}
		}
		System.out.println("===============END===============");
	}



	private static String menu() {
		System.out.println("ǰ�����=======================================================================================");		
		System.out.println("|1.��� ǰ�� ��ȸ"+"|2.ǰ�� ��ȸ"+"|3.����� ��ȸ"+"|4.Į�� ��ȸ"+"|5.���º� ��ȸ"+"|6.ǰ���Է�"+"|7.ǰ�����"+"|8.ǰ�� ����"+"|exit:������|");
		System.out.println("=============================================================================================");
		System.out.println("������ �ּ���");
		return sc.nextLine();
	}



	//f1 - ��ǰ ��ü ��ȸ 
	private static void f1() {		
			List<ProductVO> plist = service.selectAll();
			for(ProductVO product:plist) {
				System.out.println(product);
			}
		
	}

}
