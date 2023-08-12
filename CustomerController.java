package com.rent.controller;
import java.util.List;
import java.util.Scanner;
import com.rent.dto.CustomerVO;
import com.rent.model.CustomerDAO;
import com.rent.model.CustomerService;

public class CustomerController {
	static CustomerService service = new CustomerService();
	static Scanner sc = new Scanner(System.in);
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
			case "6": f6(); break;
			case "exit": flag = false; break;
			
			default:
				break;		
			}
		}
		System.out.println("===============END===============");
	}
	private static String menu() {//void 리턴없음/String 문자형식 리턴/
		System.out.println("회원관리============================================================================");		
		System.out.println("|1.회원_전체 검색"+"|2.회원_아이디검색"+"|3.회원_이름 검색"+"|4.회원가입"+"|5.회원수정"+"|6.회원탈퇴"+"|exit:끝내기|");
		System.out.println("==================================================================================");
		System.out.println("선택해 주세요");
		return sc.nextLine();
	}
	private static void f6() { //삭제
		System.out.println("삭제할 cust_id를 입력하세요. ");
		int cust_id = sc.nextInt();
		int result = service.delete(cust_id);
		System.out.println(result + "건 삭제 되었습니다");
	}
	private static void f5() {//수정
		System.out.println("수정할 cust_id를 입력하세요");
		int cust_id =  sc.nextInt();
		sc.nextLine();//cust_id가 공백으로 분리된 단어를 읽기때문에 뒷부분이 나오는 nexLine()으로 읽어버리므로 뒷부분의 값을버려준다
		System.out.println("이름을 입력하세요 ");
		String cust_name = sc.nextLine();
		System.out.println("휴대폰 번호를 입력하세요 ");
		String phone = sc.nextLine();
		System.out.println("주소를 입력하세요.(시-구-동-상세주소) ");
		String address = sc.nextLine();
		System.out.println("메일을 입력하세요 ");
		String email = sc.nextLine();
		CustomerVO customer = new CustomerVO(cust_id,cust_name, phone, address, email);
		int result = service.insert(customer);
		System.out.println(result + "건 수정 되었습니다.");
	}
	private static void f4() {//삽입
	
		System.out.println("회원가입:이름을 입력하세요 ");
		String cust_name = sc.nextLine();
		System.out.println("휴대폰 번호를 입력하세요 ");
		String phone = sc.nextLine();
		System.out.println("주소를 입력하세요.(시-구-동-상세주소) ");
		String address = sc.nextLine();
		System.out.println("메일을 입력하세요 ");
		String email = sc.nextLine();

		CustomerVO customer = new CustomerVO(cust_name, phone, address, email);
		int result = service.insert(customer);
		System.out.println(result + "건 입력");
	}
	private static void f3() {//고객이름 찾기
		System.out.println("조회할 고객이름을 입력하세요");
		String cust_name = sc.nextLine();
		CustomerVO customer = service.selectname(cust_name);
		System.out.println(customer);
	}
	private static void f2() { //Byid
		System.out.println("조회할 cust_id(고객번호)를 입력하세요");
		int cust_id = sc.nextInt();
		CustomerVO customer = service.selectByid(cust_id );
		System.out.println(customer);
	}
	private static void f1() {//전체찾기
		List<CustomerVO> clist = service.selectAll();
		for (CustomerVO customer : clist) {// clist는 CustomerVO타입에 customer를 받아서
			System.out.println(customer);
		}
	}
}
