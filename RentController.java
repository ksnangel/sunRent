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



	private static String menu() {//void ���Ͼ���/String �������� ����/
		System.out.println("��Ʈ����================================================================");		
		System.out.println("|1.��� ��Ʈ ���"+"|2.Ư�� ��Ʈ �׸� ��ȸ "+"|3.��Ʈ�Է�"+"|4.��Ʈ ����"+"|5.Rent�� ����"+"|exit:������|");
		System.out.println("=====================================================================");
		System.out.println("������ �ּ���");
		return sc.nextLine();
	}




	

	//Rent��� ����
	private static void f5() {
		System.out.println("������ cust_id�� �Է��ϼ���. >>");
		int cust_id = sc.nextInt();
		int result = service.delete(cust_id);
		System.out.println(result + "�� ���� �Ǿ����ϴ�.");
		
	}

	//��Ʈ ����  
	private static void f4() {
		RentVO rent = new RentVO();
		
	
		int rent_id = Integer.parseInt(sc.nextLine()) ;
		rent.setRent_id(rent_id);
		System.out.println("������ �����Ұ����� �Է��ϼ���");
		System.out.println("1.cust_id");
		System.out.println("2.product_id");
		System.out.println("3.rent_date");
		System.out.println("4.return_date");
		System.out.print("��ȣ�� �����ϼ���>>");
		String selectNO = sc.nextLine();
		String job= "";
		if(selectNO.equals("1")) {
			System.out.println("cust_id�� �Է��ϼ���");
			int cust_id= Integer.parseInt(sc.nextLine()) ;
			rent.setCust_id(cust_id); job = "cust_id";
		}else if(selectNO.equals("2")) {
			System.out.println("product_id�� �Է��ϼ���");
			int p_id= Integer.parseInt(sc.nextLine()) ;
			rent.setProduct_id(p_id); job = "product_id";
		}else if(selectNO.equals("3")) {
			System.out.println("rent_date�� �Է��ϼ���");
			String rent_date = sc.nextLine();
			rent.setRent_date(DateUtil.convertToDate(rent_date)); job = "rent_date";
		}else if(selectNO.equals("4")) {
			System.out.println("return_date�� �Է��ϼ���");
			String return_date = sc.nextLine();
			rent.setReturn_date(DateUtil.convertToDate(return_date)); job = "return_date";
		}

		int result =service.update(rent, job);
		System.out.println(result + "�� update");
		
	}
	
	//��Ʈ �Է�
	private static void f3() {

		System.out.println("cust_id(ȸ�� ID)�� �Է��ϼ���");
		int cust_id= Integer.parseInt(sc.nextLine()) ;
		System.out.println("product_id�� �Է��ϼ���");
		int product_id = Integer.parseInt(sc.nextLine());
		
		ProductService pservice = new ProductService();
		ProductVO product = pservice.selectProductID(product_id);
		if(product==null || product.getProduct_State().equals("�뿩��")) {
			System.out.println("�뿩�Ұ���");
			return;
		}
		
		RentVO rent = new RentVO(0, cust_id, product_id,null ,null) ;
		int result =service.insert(rent);
		System.out.println(result + "�� �Է�");
		
	}
		//Ư�� ��Ʈ �׸� ��ȸ 
	private static void f2() {
		System.out.println("RentID �� �Է��ϼ���");
		RentVO rent= service.selectRentID(1);
		
		System.out.println(rent);
	}
	
	//��� ��Ʈ��� ��ȸ
	private static void f1() {
		List<RentVO> rlist = service.selectAll();
		for(RentVO rent:rlist) {
			System.out.println(rent);
		}
		
	}

}
