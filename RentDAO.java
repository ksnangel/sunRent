package com.rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.rent.dto.CustomerVO;
import com.rent.dto.RentVO;
import com.rent.util.DBUtil;

public class RentDAO {

	static final String SQL_SELECT_ALL = "select * from rent";	
	static final String SQL_SELECT_RENTID = "select * from rent where rent_id = ? ";	
	static final String SQL_SELECT_CUSTID = "select * from rent where cust_id  = ? ";
	static final String SQL_SELECT_PRODUCTID = "select * from rent where product_id = ? ";
	static final String SQL_SELECT_RENTDATE = "select * from rent where rent_date = ? ";	
	static final String SQL_SELECT_RETURNDATE  = "select * from rent where return_date = ? ";	
	
	static final String SQL_INSERT = "INSERT INTO rent values(seq_cust.nextval, ?, ?,SYSDATE ,SYSDATE+3)";
	static final String SQL_INSERT_UPDATE = "update product set product_State = '�뿩��' where product_id = ?";
	
	
	static final String SQL_UPDATE1 = "UPDATE rent set cust_id = ?   where rent_id = ? ";	
	static final String SQL_UPDATE2= "UPDATE rent set   product_id = ?   where rent_id = ? ";	
	static final String SQL_UPDATE3 = "UPDATE rent set rent_date =?   where rent_id = ? ";	
	static final String SQL_UPDATE4 = "UPDATE rent set  return_date= ?  where rent_id = ? ";	
	
	static final String SQL_DELETE = "DELETE FROM rent where rent_id  = ? ";
	
//////////////
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	private int rent_id;

	
//////////////

	//f1-��� ��Ʈ��� ��ȸ
	public List<RentVO> selectAll() {
		List<RentVO> rlist = new ArrayList<>();
		RentVO rent = null;
		conn = DBUtil.getConnection();//DB����
		
		try {
			st = conn.prepareStatement(SQL_SELECT_ALL);//conn���ؼ� prepareStatement�� ���//SQL�������� ���̵� ������ ã�Ƽ� ��ȸ�ض� ==>try/catch
			//st.setInt(1, rent_id); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			rs = st.executeQuery(); // rs�� st���ؼ� Query�� �����ϵ��� 
			while (rs.next()) {// rs�� next�ؼ� ��� �о��				
				rent = makeRent(rs);//�о�� ==>create method �����     makeRent(
				rlist.add(rent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return rlist;		
	}
	//f2 -Ư�� ��Ʈ �׸� ��ȸ
	public RentVO selectRentID(int rent_id) { //Ư��rent_id�� ��ȸ�ϱ�
		RentVO rent = null;
		conn = DBUtil.getConnection();//DB����
		
		try {
			st = conn.prepareStatement(SQL_SELECT_RENTID);//conn���ؼ� prepareStatement�� ���//SQL�������� ���̵� ������ ã�Ƽ� ��ȸ�ض� ==>try/catch
			st.setInt(1, rent_id); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			rs = st.executeQuery(); // rs�� st���ؼ� Query�� �����ϵ��� 
			while (rs.next()) {// rs�� next�ؼ� ��� �о��
				rent = makeRent(rs);//�о�� ==>create method �����     makeRent(
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return rent;		
	}
	//��Ʈ �Ӽ��� �� ���ٸ�(rent)�� �ֱ� -������ ������ 
	private RentVO makeRent(ResultSet rs) throws SQLException { //makeRent
		RentVO rent = new RentVO();
		rent.setRent_id(rs.getInt(1));//rs.getInt(1)���� ������
		rent.setCust_id(rs.getInt(2));//rs.getInt(1)���� ������
		rent.setProduct_id(rs.getInt(3));
		rent.setRent_date(rs.getDate(4));
		rent.setReturn_date(rs.getDate(5));		
		return rent;
	}
	//��Ʈ ��id�� ��Ʈ ��ȸ
	public RentVO selectCustID(int cust_id) {
		List<RentVO> rlist = new ArrayList<>();
		RentVO rent = null;
		conn = DBUtil.getConnection();//DB����
		
		try {
			st = conn.prepareStatement(SQL_SELECT_ALL);//conn���ؼ� prepareStatement�� ���//SQL�������� ���̵� ������ ã�Ƽ� ��ȸ�ض� ==>try/catch
			//st.setInt(1, rent_id); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			rs = st.executeQuery(); // rs�� st���ؼ� Query�� �����ϵ��� 
			while (rs.next()) {// rs�� next�ؼ� ��� �о��				
				rent = makeRent(rs);//�о�� ==>create method �����     makeRent(
				rlist.add(rent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return rent;		

	}
	public RentVO selectProductID(int product_id) {
		RentVO rent = null;
		conn = DBUtil.getConnection();//DB����
		
		try {
			st = conn.prepareStatement(SQL_SELECT_PRODUCTID);//conn���ؼ� prepareStatement�� ���//SQL�������� ���̵� ������ ã�Ƽ� ��ȸ�ض� ==>try/catch
			st.setInt(1, product_id); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			rs = st.executeQuery(); // rs�� st���ؼ� Query�� �����ϵ��� 
			while (rs.next()) {// rs�� next�ؼ� ��� �о��
				rent = makeRent(rs);//�о�� ==>create method �����     makeRent(
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return rent;
	}
	public List<RentVO> selectRentDate(String rent_date) {
		List<RentVO> rlist = new ArrayList<>();
		RentVO rent = null;
		conn = DBUtil.getConnection();//DB����
		
		try {
			st = conn.prepareStatement(SQL_SELECT_RENTDATE );//conn���ؼ� prepareStatement�� ���//SQL�������� ���̵� ������ ã�Ƽ� ��ȸ�ض� ==>try/catch
			//st.setInt(1, rent_id); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			rs = st.executeQuery(); // rs�� st���ؼ� Query�� �����ϵ��� 
			while (rs.next()) {// rs�� next�ؼ� ��� �о��				
				rent = makeRent(rs);//�о�� ==>create method �����     makeRent(
				rlist.add(rent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return rlist;
	}
	public List<RentVO> selectReturnDate(String return_date) {
		List<RentVO> rlist = new ArrayList<>();
		RentVO rent = null;
		conn = DBUtil.getConnection();//DB����
		
		try {
			st = conn.prepareStatement(SQL_SELECT_RETURNDATE);//conn���ؼ� prepareStatement�� ���//SQL�������� ���̵� ������ ã�Ƽ� ��ȸ�ض� ==>try/catch
			//st.setInt(1, rent_id); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			rs = st.executeQuery(); // rs�� st���ؼ� Query�� �����ϵ��� 
			while (rs.next()) {// rs�� next�ؼ� ��� �о��				
				rent = makeRent(rs);//�о�� ==>create method �����     makeRent(
				rlist.add(rent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return rlist;
	}

	
	
	
	public int insert(RentVO rent) {	
		
		PreparedStatement st2 = null;
		conn = DBUtil.getConnection();//DB����		
		int[] result2 = new int[2];
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement(SQL_INSERT);		
			st.setInt(1, rent.getCust_id()); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			st.setInt(2, rent.getProduct_id()); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			result2[0] = st.executeUpdate();
			
			st2 =  conn.prepareStatement(SQL_INSERT_UPDATE);	
			st2.setInt(1, rent.getProduct_id());
			result2[1] =st2.executeUpdate();
			
			 
			System.out.println(Arrays.toString(result2));
			conn.commit();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBUtil.dbClose(rs, st, conn);
			
		}
		return result2[0] + result2[1];		
	}
	
	 
	public int update(RentVO rent, String job) {
		conn = DBUtil.getConnection();//DB����		
		try {
			if(job.equals("cust_id")) {
				st = conn.prepareStatement(SQL_UPDATE1);
				st.setInt(1, rent.getCust_id()); 
			}else if(job.equals("product_id")) {
				st = conn.prepareStatement(SQL_UPDATE2);
				st.setInt(1, rent.getProduct_id()); 
			}else if(job.equals("rent_date")) {
				st = conn.prepareStatement(SQL_UPDATE3);
				st.setDate(1, rent.getRent_date());
			}else if(job.equals("return_date")) {
				st = conn.prepareStatement(SQL_UPDATE4);
				st.setDate(1, rent.getReturn_date());
			}
			st.setInt(2, rent.getRent_id());
		    result = st.executeUpdate();
		
		
		
			//conn���ؼ� prepareStatement�� ���//SQL�������� ���̵� ������ ã�Ƽ� ��ȸ�ض� ==>try/catch
			// ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			//st.setInt(2, rent.getProduct_id()); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			//st.setString(3, rent.getRent_date()); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			//st.setString(4, rent.getReturn_date()); // ?ǥ�� �����Ƿ�  ==>BYID 1��° ?���� cust_id�� �־��ش�
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return result;			
	}
	public int delete(int cust_id) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_DELETE);
			st.setInt(1,rent_id);
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
			
	}
	
}
