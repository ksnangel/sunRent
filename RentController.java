package com.rent.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.rent.dto.ProductVO;
import com.rent.dto.RentVO;
import com.rent.model.ProductService;
import com.rent.model.RentService;
import com.rent.util.DateUtil;

public class RentController {
	static RentService service = new RentService();
	static Scanner sc = new Scanner (System.in);
	
	static Date now = new Date();
	static Calendar cal = Calendar.getInstance(); 
	static boolean flag=true;
	public static void main(String[] args) {
		
		while (flag) {
			String selectNO = menu();
			switch  (selectNO) {
			case "1": f1(); break;
			case "2": f2(); break;
			case "3": f3(); break;
			case "4": f4(); break;
			case "5": f5(); break;			
			case "exit": flag = false; break;
			
			default:
				break;
			
			}
		}
		System.out.println("===============END===============");
	}



	private static String menu() {//void 리턴없음/String 문자형식 리턴/
		System.out.println("렌트관리================================================================");		
		System.out.println("|1.모든 렌트 목록"+"|2.특정 렌트 항목 조회 "+"|3.렌트입력"+"|4.렌트 수정"+"|5.Rent행 삭제"+"|exit:끝내기|");
		System.out.println("=====================================================================");
		System.out.println("선택해 주세요");
		return sc.nextLine();
	}




	

	//Rent목록 삭제
	private static void f5() {
		System.out.println("삭제할 cust_id를 입력하세요. >>");
		int cust_id = sc.nextInt();
		int result = service.delete(cust_id);
		System.out.println(result + "건 삭제 되었습니다.");
		
	}

	//렌트 수정  
	private static void f4() {
		RentVO rent = new RentVO();
		
	
		int rent_id = Integer.parseInt(sc.nextLine()) ;
		rent.setRent_id(rent_id);
		System.out.println("무엇을 수정할것인지 입력하세요");
		System.out.println("1.cust_id");
		System.out.println("2.product_id");
		System.out.println("3.rent_date");
		System.out.println("4.return_date");
		System.out.print("번호를 선택하세요>>");
		String selectNO = sc.nextLine();
		String job= "";
		if(selectNO.equals("1")) {
			System.out.println("cust_id를 입력하세요");
			int cust_id= Integer.parseInt(sc.nextLine()) ;
			rent.setCust_id(cust_id); job = "cust_id";
		}else if(selectNO.equals("2")) {
			System.out.println("product_id를 입력하세요");
			int p_id= Integer.parseInt(sc.nextLine()) ;
			rent.setProduct_id(p_id); job = "product_id";
		}else if(selectNO.equals("3")) {
			System.out.println("rent_date를 입력하세요");
			String rent_date = sc.nextLine();
			rent.setRent_date(DateUtil.convertToDate(rent_date)); job = "rent_date";
		}else if(selectNO.equals("4")) {
			System.out.println("return_date를 입력하세요");
			String return_date = sc.nextLine();
			rent.setReturn_date(DateUtil.convertToDate(return_date)); job = "return_date";
		}

		int result =service.update(rent, job);
		System.out.println(result + "건 update");
		
	}
	
	//렌트 입력
	private static void f3() {

		System.out.println("cust_id(회원 ID)를 입력하세요");
		int cust_id= Integer.parseInt(sc.nextLine()) ;
		System.out.println("product_id를 입력하세요");
		int product_id = Integer.parseInt(sc.nextLine());
		
		ProductService pservice = new ProductService();
		ProductVO product = pservice.selectProductID(product_id);
		if(product==null || product.getProduct_State().equals("대여중")) {
			System.out.println("대여불가능");
			return;
		}
		
		RentVO rent = new RentVO(0, cust_id, product_id,null ,null) ;
		int result =service.insert(rent);
		System.out.println(result + "건 입력");
		
	}
		//특정 렌트 항목 조회 
	private static void f2() {
		System.out.println("RentID 를 입력하세요");
		RentVO rent= service.selectRentID(1);
		
		System.out.println(rent);
	}
	
	//모든 렌트목록 조회
	private static void f1() {
		List<RentVO> rlist = service.selectAll();
		for(RentVO rent:rlist) {
			System.out.println(rent);
		}
		
	}

}
