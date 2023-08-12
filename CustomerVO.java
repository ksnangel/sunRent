package com.rent.dto;
//jdbc: util(DB����)  =>  1�� VO�غ� =>  2�� DAO: model�� ����(CRUD=�������,�Լ���) => DAO �Լ����� �����ؼ� Service�� �����ͼ� �ٿ��ִ´�.
				       //4�� Service�� �Լ� �ٿ����� Service�� new�ɶ� dao�� new �ǰ�( Controller�� DAO ���̿��� �Լ��� �߰��ٸ�����), returnŸ�� ����(dao.�����̸�)
                       //5�� �ٽ� DAO������ DB�� �����ϰ� �����Ͻ� ������ §��.(Connection,PreparedStatement,ResultSet, ���� ���� �� ���� ¥��)

//1. � �����͵��� �ִ�   => �����̺� ���������� ���� 
public class CustomerVO { //�����Ͱ� ����ִ� ����
	//cust_id(����ȣ) �˾Ƽ� �ڵ������ȴ�.
	private int cust_id	;
	private String cust_name ;
	private String phone;
	private String address;
	private String email;


//2. �����͸� ��� �־�߰ڴ�  => � �����ڰ� �ְ� �׷��� �ְڴ�(source --> Constructor(������) -->����) 
	//1) �ƹ��͵����� ������	
	public CustomerVO() { 
		super();
	}
	//2) ���ִ� ������
	public CustomerVO(int cust_id, String cust_name, String phone, String address, String email) {
	super();
	this.cust_id = cust_id;
	this.cust_name = cust_name;
	this.phone = phone;
	this.address = address;
	this.email = email;
	}
	//3)�ʿ��Ѱ� ������(������ �Է¹޾ƾ� �� ������) 
	public CustomerVO(String cust_name, String phone, String address, String email) {
		super();
		this.cust_name = cust_name;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
//3.�ܺο��� ���� �����ϰų� �о�� �ǰڴ�(source --> getter/setter -->����) 	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//4.���� ���� Ȯ���Ҷ��� ToString���� �ϰڴ�.(source --> ToString -->����)
	@Override
	public String toString() {
		return "CustomerVO [cust_id=" + cust_id + ", cust_name=" + cust_name + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + "]";
	}

	
}
