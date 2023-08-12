package com.rent.dto;
//jdbc: util(DB연결)  =>  1번 VO준비 =>  2번 DAO: model에 어떤기능(CRUD=상수선언,함수들) => DAO 함수들을 복사해서 Service로 가져와서 붙여넣는다.
				       //4번 Service에 함수 붙여놓고 Service가 new될때 dao가 new 되게( Controller와 DAO 사이에서 함수로 중간다리연결), return타입 정리(dao.같은이름)
                       //5번 다시 DAO에가서 DB를 연결하고 비지니스 로직을 짠다.(Connection,PreparedStatement,ResultSet, 변수 선언 등 로직 짜기)

//1. 어떤 데이터들이 있다   => 고객테이블 변수명으로 선언 
public class CustomerVO { //데이터가 들어있는 가방
	//cust_id(고객번호) 알아서 자동생성된다.
	private int cust_id	;
	private String cust_name ;
	private String phone;
	private String address;
	private String email;


//2. 데이터를 어떻게 넣어야겠다  => 어떤 생성자가 있고 그렇게 넣겠다(source --> Constructor(생성자) -->선택) 
	//1) 아무것도없는 생성자	
	public CustomerVO() { 
		super();
	}
	//2) 다있는 생성자
	public CustomerVO(int cust_id, String cust_name, String phone, String address, String email) {
	super();
	this.cust_id = cust_id;
	this.cust_name = cust_name;
	this.phone = phone;
	this.address = address;
	this.email = email;
	}
	//3)필요한것 생성자(고객정보 입력받아야 할 생성자) 
	public CustomerVO(String cust_name, String phone, String address, String email) {
		super();
		this.cust_name = cust_name;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
//3.외부에서 값을 수정하거나 읽어야 되겠다(source --> getter/setter -->선택) 	
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
	
//4.내가 값을 확인할때는 ToString으로 하겠다.(source --> ToString -->선택)
	@Override
	public String toString() {
		return "CustomerVO [cust_id=" + cust_id + ", cust_name=" + cust_name + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + "]";
	}

	
}
