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
	private static String menu() {//void ���Ͼ���/String �������� ����/
		System.out.println("ȸ������============================================================================");		
		System.out.println("|1.ȸ��_��ü �˻�"+"|2.ȸ��_���̵�˻�"+"|3.ȸ��_�̸� �˻�"+"|4.ȸ������"+"|5.ȸ������"+"|6.ȸ��Ż��"+"|exit:������|");
		System.out.println("==================================================================================");
		System.out.println("������ �ּ���");
		return sc.nextLine();
	}
	private static void f6() { //����
		System.out.println("������ cust_id�� �Է��ϼ���. ");
		int cust_id = sc.nextInt();
		int result = service.delete(cust_id);
		System.out.println(result + "�� ���� �Ǿ����ϴ�");
	}
	private static void f5() {//����
		System.out.println("������ cust_id�� �Է��ϼ���");
		int cust_id =  sc.nextInt();
		sc.nextLine();//cust_id�� �������� �и��� �ܾ �б⶧���� �޺κ��� ������ nexLine()���� �о�����Ƿ� �޺κ��� ���������ش�
		System.out.println("�̸��� �Է��ϼ��� ");
		String cust_name = sc.nextLine();
		System.out.println("�޴��� ��ȣ�� �Է��ϼ��� ");
		String phone = sc.nextLine();
		System.out.println("�ּҸ� �Է��ϼ���.(��-��-��-���ּ�) ");
		String address = sc.nextLine();
		System.out.println("������ �Է��ϼ��� ");
		String email = sc.nextLine();
		CustomerVO customer = new CustomerVO(cust_id,cust_name, phone, address, email);
		int result = service.insert(customer);
		System.out.println(result + "�� ���� �Ǿ����ϴ�.");
	}
	private static void f4() {//����
	
		System.out.println("ȸ������:�̸��� �Է��ϼ��� ");
		String cust_name = sc.nextLine();
		System.out.println("�޴��� ��ȣ�� �Է��ϼ��� ");
		String phone = sc.nextLine();
		System.out.println("�ּҸ� �Է��ϼ���.(��-��-��-���ּ�) ");
		String address = sc.nextLine();
		System.out.println("������ �Է��ϼ��� ");
		String email = sc.nextLine();

		CustomerVO customer = new CustomerVO(cust_name, phone, address, email);
		int result = service.insert(customer);
		System.out.println(result + "�� �Է�");
	}
	private static void f3() {//���̸� ã��
		System.out.println("��ȸ�� ���̸��� �Է��ϼ���");
		String cust_name = sc.nextLine();
		CustomerVO customer = service.selectname(cust_name);
		System.out.println(customer);
	}
	private static void f2() { //Byid
		System.out.println("��ȸ�� cust_id(����ȣ)�� �Է��ϼ���");
		int cust_id = sc.nextInt();
		CustomerVO customer = service.selectByid(cust_id );
		System.out.println(customer);
	}
	private static void f1() {//��üã��
		List<CustomerVO> clist = service.selectAll();
		for (CustomerVO customer : clist) {// clist�� CustomerVOŸ�Կ� customer�� �޾Ƽ�
			System.out.println(customer);
		}
	}
}
