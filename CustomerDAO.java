package com.rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rent.dto.CustomerVO;
import com.rent.util.DBUtil;

//jdbc: util(DB연결)  =>  1번 VO준비 =>  2번 DAO: model에 어떤기능(CRUD=상수선언,함수들) => 함수들을 복사해서 Service로 가져간다. 
//3번  
//DAO (CRUD=상수선언,함수들)  내가 필요하다고 생각되는 기능들을 쓴다. 고객이 회원가입하고 CRUD하게!! 

public class CustomerDAO {// 비지니스 로직
	// 1. CRUD 기능 --> SQL문장을 상수로 써버리겠다.
	// ----조회기능--- //
	// - customer 전부조회
	static final String SQL_SELECT_ALL = "select * from customer ORDER BY CUST_ID ";
	// - customer //cust_id 조회
	static final String SQL_SELECT_BYID = "select * from customer where cust_id = ? ";
	// - customer //cust_name 조회
	static final String SQL_SELECT_BYNAME = "select * from customer where cust_name = ? ";


	// ----삽입 insert--- //
	static final String SQL_INSERT = "INSERT INTO customer values(seq_cust.nextval, ?, ?, ?, ?)";
	// ----수정 update--- //
	static final String SQL_UPDATE = "UPDATE customer set cust_name = ? , phone = ?, address = ?, email = ? | where cust_id = ? ";
	// ----삭제 delete--- //
	static final String SQL_DELETE = "DELETE FROM customer where cust_id = ? ";
	// -----------------------------------
	// DAO에 와서 DB연결객체Connection (import java.sql.Connection)
	Connection conn;
	// Statement클래스(Query 작업을 실행하기 위한 객체.PreparedStatement( ? 바인딩 변수를 지원하는 등)가 기능이 더
	// 많다 )
	PreparedStatement st;
	// ResultSet(java.sql.ResultSet)은 executeQuery(String sql)을 통해 쿼리 실행하면
	// ResultSet타입으로 반환을 해주어 결과값을 저장할 수 있다.
	ResultSet rs;
	// insert,delete,update 건수이므로 int타입변수 result로 선언
	int result;
	private CustomerVO customer;
	private String cust_name;

	// List타입(BoardVO형태) 전체조회
	public List<CustomerVO> selectAll() {
		List<CustomerVO> clist = new ArrayList<>();
		CustomerVO customer = null; //초기화
		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(SQL_SELECT_ALL);// 아이디가 같은걸 찾아서 조회해라
			// st.setInt(1, "%"+ cust_name +); //? 물음표없으니 삭제
			rs = st.executeQuery(); // rs는 st문에서 Query를 실행하도록 보내-
			while (rs.next()) {// rs를 next해서 계속 읽어라
				customer = makeCustomer(rs);
				clist.add(customer);// clist에 더해라(customer에 있는)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}

		return clist;
	}
	private CustomerVO makeCustomer(ResultSet rs) throws SQLException {
		//throws는 예외를 호출한 곳으로 떠넘겨라
		//throws키워드가 붙어있는 메소드는 반드시 try 블록 내에서 호출되어야 하고 catch블록에서 떠넘겨 받은 예외를 처리해야 한다.
		CustomerVO customer = new CustomerVO();// new로 CustomerVO타입 객체customer 만들기
		
		customer.setCust_id(rs.getInt(1)); // setCust_id로 rs.getInt를 첫번째로 받는다 =>throws SQLException
		customer.setCust_name(rs.getString(2));//rs.getInt를 2번째로 받는다
		customer.setPhone(rs.getString(3));//rs.getInt를 3번째로 받는다
		customer.setAddress(rs.getString(4));//rs.getInt를 4번째로 받는다
		customer.setEmail(rs.getString(5));//rs.getInt를 5번째로 받는다

		return customer;//customer로 반납
	}
	// BoardVO형태 한건 조회
	public CustomerVO selectByid(int cust_id) {
		// 로직을 작성하진 않았으니 일단 null로 해놓는다.
		CustomerVO customer = null; // customer 초기화
		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(SQL_SELECT_BYID);// 아이디가 같은걸 찾아서 조회해라
			st.setInt(1, cust_id); // BYID 1번째 ?에서 cust_id를 넣어준다
			rs = st.executeQuery(); // rs는 st문에서 Query를 실행하도록 보내-
			while (rs.next()) {// rs를 next해서 계속 읽어라
				customer = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}
		return customer;// rent가 채워지면 return 한다
	}
	//이름조회
	public CustomerVO selectname(String cust_name) {
		CustomerVO customer = null; // customer 초기화
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_SELECT_BYNAME);// 아이디가 같은걸 찾아서 조회해라
			st.setString(1, cust_name); // "%"+cust_name+"%" ==> ??   BYID 1번째 ?에서 cust_id를 넣어준다
			rs = st.executeQuery(); // rs는 st문에서 Query를 실행하도록 보내-
			while (rs.next()) {// rs를 next해서 계속 읽어라
				customer = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}
		return customer;// rent가 채워지면 return 한다
	}
	// insert 건수 무슨타입에 무엇을 몇건 삽입해라
	public int insert(CustomerVO customer) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_INSERT);// 아이디가 같은걸 찾아서 조회해라
			st.setString(1, customer.getCust_name()); // BYID 1번째 ?에서 cust_id를 넣어준다
			st.setString(2, customer.getPhone());
			st.setString(3, customer.getAddress());
			st.setString(4, customer.getEmail());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}
		return result;// customer가 채워지면 return 한다
	}
	// update 건수 무슨타입에 무엇을 수정해라 
	public int update(CustomerVO customer) {//번호가 아니라 객체로 들어온다
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_UPDATE);			
			st.setString(1, customer.getCust_name()); // BYID 1번째 ?에서 cust_id를 넣어준다
			st.setString(2, customer.getPhone());
			st.setString(3, customer.getAddress());
			st.setString(4, customer.getEmail());
			st.setInt(5, customer.getCust_id());
			result = st.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}
		return result;// customer가 채워지면 return 한다
	}
	// delete 건수 무슨타입에 무엇을 삭제해라
	public int delete(int cust_id) {//객체가 아니라 번호로 들어온다

		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_DELETE);
			st.setInt(1, cust_id);
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}

	// 함수들을 복사해서 Service로 가져간다.
}
