package com.rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rent.dto.CustomerVO;
import com.rent.util.DBUtil;

//jdbc: util(DB����)  =>  1�� VO�غ� =>  2�� DAO: model�� ����(CRUD=�������,�Լ���) => �Լ����� �����ؼ� Service�� ��������. 
//3��  
//DAO (CRUD=�������,�Լ���)  ���� �ʿ��ϴٰ� �����Ǵ� ��ɵ��� ����. ���� ȸ�������ϰ� CRUD�ϰ�!! 

public class CustomerDAO {// �����Ͻ� ����
	// 1. CRUD ��� --> SQL������ ����� ������ڴ�.
	// ----��ȸ���--- //
	// - customer ������ȸ
	static final String SQL_SELECT_ALL = "select * from customer ORDER BY CUST_ID ";
	// - customer //cust_id ��ȸ
	static final String SQL_SELECT_BYID = "select * from customer where cust_id = ? ";
	// - customer //cust_name ��ȸ
	static final String SQL_SELECT_BYNAME = "select * from customer where cust_name = ? ";


	// ----���� insert--- //
	static final String SQL_INSERT = "INSERT INTO customer values(seq_cust.nextval, ?, ?, ?, ?)";
	// ----���� update--- //
	static final String SQL_UPDATE = "UPDATE customer set cust_name = ? , phone = ?, address = ?, email = ? | where cust_id = ? ";
	// ----���� delete--- //
	static final String SQL_DELETE = "DELETE FROM customer where cust_id = ? ";
	// -----------------------------------
	// DAO�� �ͼ� DB���ᰴüConnection (import java.sql.Connection)
	Connection conn;
	// StatementŬ����(Query �۾��� �����ϱ� ���� ��ü.PreparedStatement( ? ���ε� ������ �����ϴ� ��)�� ����� ��
	// ���� )
	PreparedStatement st;
	// ResultSet(java.sql.ResultSet)�� executeQuery(String sql)�� ���� ���� �����ϸ�
	// ResultSetŸ������ ��ȯ�� ���־� ������� ������ �� �ִ�.
	ResultSet rs;
	// insert,delete,update �Ǽ��̹Ƿ� intŸ�Ժ��� result�� ����
	int result;
	private CustomerVO customer;
	private String cust_name;

	// ListŸ��(BoardVO����) ��ü��ȸ
	public List<CustomerVO> selectAll() {
		List<CustomerVO> clist = new ArrayList<>();
		CustomerVO customer = null; //�ʱ�ȭ
		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(SQL_SELECT_ALL);// ���̵� ������ ã�Ƽ� ��ȸ�ض�
			// st.setInt(1, "%"+ cust_name +); //? ����ǥ������ ����
			rs = st.executeQuery(); // rs�� st������ Query�� �����ϵ��� ����-
			while (rs.next()) {// rs�� next�ؼ� ��� �о��
				customer = makeCustomer(rs);
				clist.add(customer);// clist�� ���ض�(customer�� �ִ�)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}

		return clist;
	}
	private CustomerVO makeCustomer(ResultSet rs) throws SQLException {
		//throws�� ���ܸ� ȣ���� ������ ���Ѱܶ�
		//throwsŰ���尡 �پ��ִ� �޼ҵ�� �ݵ�� try ��� ������ ȣ��Ǿ�� �ϰ� catch��Ͽ��� ���Ѱ� ���� ���ܸ� ó���ؾ� �Ѵ�.
		CustomerVO customer = new CustomerVO();// new�� CustomerVOŸ�� ��ücustomer �����
		
		customer.setCust_id(rs.getInt(1)); // setCust_id�� rs.getInt�� ù��°�� �޴´� =>throws SQLException
		customer.setCust_name(rs.getString(2));//rs.getInt�� 2��°�� �޴´�
		customer.setPhone(rs.getString(3));//rs.getInt�� 3��°�� �޴´�
		customer.setAddress(rs.getString(4));//rs.getInt�� 4��°�� �޴´�
		customer.setEmail(rs.getString(5));//rs.getInt�� 5��°�� �޴´�

		return customer;//customer�� �ݳ�
	}
	// BoardVO���� �Ѱ� ��ȸ
	public CustomerVO selectByid(int cust_id) {
		// ������ �ۼ����� �ʾ����� �ϴ� null�� �س��´�.
		CustomerVO customer = null; // customer �ʱ�ȭ
		conn = DBUtil.getConnection();

		try {
			st = conn.prepareStatement(SQL_SELECT_BYID);// ���̵� ������ ã�Ƽ� ��ȸ�ض�
			st.setInt(1, cust_id); // BYID 1��° ?���� cust_id�� �־��ش�
			rs = st.executeQuery(); // rs�� st������ Query�� �����ϵ��� ����-
			while (rs.next()) {// rs�� next�ؼ� ��� �о��
				customer = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return customer;// rent�� ä������ return �Ѵ�
	}
	//�̸���ȸ
	public CustomerVO selectname(String cust_name) {
		CustomerVO customer = null; // customer �ʱ�ȭ
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_SELECT_BYNAME);// ���̵� ������ ã�Ƽ� ��ȸ�ض�
			st.setString(1, cust_name); // "%"+cust_name+"%" ==> ??   BYID 1��° ?���� cust_id�� �־��ش�
			rs = st.executeQuery(); // rs�� st������ Query�� �����ϵ��� ����-
			while (rs.next()) {// rs�� next�ؼ� ��� �о��
				customer = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return customer;// rent�� ä������ return �Ѵ�
	}
	// insert �Ǽ� ����Ÿ�Կ� ������ ��� �����ض�
	public int insert(CustomerVO customer) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_INSERT);// ���̵� ������ ã�Ƽ� ��ȸ�ض�
			st.setString(1, customer.getCust_name()); // BYID 1��° ?���� cust_id�� �־��ش�
			st.setString(2, customer.getPhone());
			st.setString(3, customer.getAddress());
			st.setString(4, customer.getEmail());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return result;// customer�� ä������ return �Ѵ�
	}
	// update �Ǽ� ����Ÿ�Կ� ������ �����ض� 
	public int update(CustomerVO customer) {//��ȣ�� �ƴ϶� ��ü�� ���´�
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_UPDATE);			
			st.setString(1, customer.getCust_name()); // BYID 1��° ?���� cust_id�� �־��ش�
			st.setString(2, customer.getPhone());
			st.setString(3, customer.getAddress());
			st.setString(4, customer.getEmail());
			st.setInt(5, customer.getCust_id());
			result = st.executeUpdate();
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return result;// customer�� ä������ return �Ѵ�
	}
	// delete �Ǽ� ����Ÿ�Կ� ������ �����ض�
	public int delete(int cust_id) {//��ü�� �ƴ϶� ��ȣ�� ���´�

		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_DELETE);
			st.setInt(1, cust_id);
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}

	// �Լ����� �����ؼ� Service�� ��������.
}
