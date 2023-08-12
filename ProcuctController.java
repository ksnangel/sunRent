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
		System.out.println("품목관리=======================================================================================");		
		System.out.println("|1.모든 품목 조회"+"|2.품목별 조회"+"|3.사이즈별 조회"+"|4.칼라별 조회"+"|5.상태별 조회"+"|6.품목입력"+"|7.품목수정"+"|8.품목 삭제"+"|exit:끝내기|");
		System.out.println("=============================================================================================");
		System.out.println("선택해 주세요");
		return sc.nextLine();
	}



	//f1 - 상품 전체 조회 
	private static void f1() {		
			List<ProductVO> plist = service.selectAll();
			for(ProductVO product:plist) {
				System.out.println(product);
			}
		
	}

}
