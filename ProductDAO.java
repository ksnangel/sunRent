package com.rent.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rent.dto.ProductVO;
import com.rent.util.DBUtil;

public class ProductDAO {

	static final String SQL_SELECT_ALL = "select * from product";	
	static final String SQL_SELECT_PRODUCTID = "select * from product where product_id = ? ";	
	static final String SQL_SELECT_PNAME = "select * from product where product_name = ? ";
	static final String SQL_SELECT_PSIZE = "select * from product where product_size = ? ";
	static final String SQL_SELECT_PCOLOR = "select * from product where product_color = ? ";	
	static final String SQL_SELECT_PSTATE = "select * from product where product_State= ? ";	
	
	static final String SQL_INSERT = "INSERT INTO product values(seq_cust.nextval, ?, ?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE product set product_name = ? , product_size = ?, product_color = ?, product_State= ? where product_id= ? ";	
	static final String SQL_DELETE = "DELETE FROM product where rent_id  = ? ";
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	private int result;
	private int product_id;
	
	////��� ��ǰ ��ȸ
	public List<ProductVO> selectAll() {
		List<ProductVO> plist = new ArrayList<>();
		ProductVO product = null;
		conn = DBUtil.getConnection();//DB����
		
		try {
			st = conn.prepareStatement(SQL_SELECT_ALL);//conn���ؼ� prepareStatement�� ���//SQL�������� ���̵� ������ ã�Ƽ� ��ȸ�ض� ==>try/catch			
			rs = st.executeQuery(); // rs�� st���ؼ� Query�� �����ϵ��� 
			while (rs.next()) {// rs�� next�ؼ� ��� �о��				
				product = makeProduct(rs);//�о�� ==>create method �����     makeRent(
				plist.add(product);
			}
		} catch (SQLException e) {
			//catch�� ��ȣ()�� ��{} �κκ����� �������ִµ�, ��ȣ���� ó���ϰ����ϴ� ����Ÿ��(Exception), ��������(e)�� �����Ѵ�.
			//���ܹ߻��� �߻����ܿ� �ش��ϴ� Ŭ������ �ν��Ͻ��� ���������.
			e.printStackTrace(); //���� ���� ���
			//printStackTrace(): ���ܹ߻������ ȣ�⽺��(Call Stack)�� �־��� �޼����� ������ ���� �޼����� �ܼ�ȭ�鿡 ����Ѵ�

		} finally {  //finally�� //���ܹ߻����ο� ������� ������ ����Ǿ�� �ϴ� �������´�.
			DBUtil.dbClose(rs, st, conn);// DB�� �����ֱ�
		}
		return plist;// �ڿ� �ݳ�		
	}
	//���ʿ�_��ǰ product_id�� ��ȸ
	public ProductVO selectProductid(int product_id) {	
		ProductVO product = null;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from product  where product_id = " + product_id;	
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				product = makeProduct(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return product;
		
	}
	//ProductVO product���� SQL������ get�ؼ� set
	private ProductVO makeProduct(ResultSet rs) throws SQLException { //makeProduct
		
		ProductVO product = new ProductVO();
		product.setProduct_name(rs.getString(2));
		product.setProduct_size(rs.getString(3));
		product.setProduct_color(rs.getString(4));
		product.setProduct_State(rs.getString(5));		
		return product;
	}
	//��ǰ �̸��� ��ȸ
	public ProductVO selectPname(String product_name) {
		ProductVO product = null;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from product  where product_name = " + product_name;	
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				product = makeProduct(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return product;
	}
	//����� Product ��ȸ
	public ProductVO selectPsize(String  product_size) {
		ProductVO product = null;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from product  where product_size = " + product_size;	
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				product = makeProduct(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return product;
	}
	//Į�� Product ��ȸ
	public ProductVO selectPcolor(String product_color) {
		ProductVO product = null;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from product  where product_color = " + product_color;	
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				product = makeProduct(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return product;
	}
	//Product ����(�뿩/����)�� ��ȸ
	public ProductVO selectPstate(String product_State) {
		ProductVO product = null;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from product  where product_State = " + product_State;	
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				product = makeProduct(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return product;
	}

	//Product �Է�
	public int insert(ProductVO product) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_INSERT);// ���̵� ������ ã�Ƽ� ��ȸ�ض�

			st.setString(1, product.getProduct_name()); // BYID 1��° ?���� cust_id�� �־��ش�
			st.setString(2, product.getProduct_size());
			st.setString(3, product.getProduct_color());
			st.setString(4, product.getProduct_State());
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return result;// customer�� ä������ return �Ѵ�		
	}
	//Product ����
	public int update(ProductVO product) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_UPDATE);// ���̵� ������ ã�Ƽ� ��ȸ�ض�

			st.setString(1, product.getProduct_name()); // BYID 1��° ?���� cust_id�� �־��ش�
			st.setString(2, product.getProduct_size());
			st.setString(3, product.getProduct_color());
			st.setString(4, product.getProduct_State());
			st.setInt(5, product.getProduct_id());
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return result;// customer�� ä������ return �Ѵ�			
	}
	
	//Product ����
	public int delete(int product) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_DELETE);
			st.setInt(1, product_id);
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB�� �����ְ� �ڿ��ݳ�
			DBUtil.dbClose(rs, st, conn);
		}
		return result;		
	}
}
