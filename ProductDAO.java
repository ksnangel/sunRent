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
	
	////모든 상품 조회
	public List<ProductVO> selectAll() {
		List<ProductVO> plist = new ArrayList<>();
		ProductVO product = null;
		conn = DBUtil.getConnection();//DB연결
		
		try {
			st = conn.prepareStatement(SQL_SELECT_ALL);//conn통해서 prepareStatement를 얻어//SQL문장으로 아이디가 같은걸 찾아서 조회해라 ==>try/catch			
			rs = st.executeQuery(); // rs는 st통해서 Query를 실행하도록 
			while (rs.next()) {// rs를 next해서 계속 읽어라				
				product = makeProduct(rs);//읽어라 ==>create method 만들기     makeRent(
				plist.add(product);
			}
		} catch (SQLException e) {
			//catch는 괄호()와 블럭{} 두부분으로 나눠져있는데, 괄호에는 처리하고자하는 예외타입(Exception), 참조변수(e)를 선언한다.
			//예외발생시 발생예외에 해당하는 클래스의 인스턴스가 만들어진다.
			e.printStackTrace(); //예외 정보 출력
			//printStackTrace(): 예외발생당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메세지를 콘솔화면에 출력한다

		} finally {  //finally는 //예외발생여부에 관계없이 무조건 수행되어야 하는 문장적는다.
			DBUtil.dbClose(rs, st, conn);// DB를 끊어주기
		}
		return plist;// 자원 반납		
	}
	//불필요_상품 product_id별 조회
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
	//ProductVO product에서 SQL문으로 get해서 set
	private ProductVO makeProduct(ResultSet rs) throws SQLException { //makeProduct
		
		ProductVO product = new ProductVO();
		product.setProduct_name(rs.getString(2));
		product.setProduct_size(rs.getString(3));
		product.setProduct_color(rs.getString(4));
		product.setProduct_State(rs.getString(5));		
		return product;
	}
	//상품 이름별 조회
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
	//사이즈별 Product 조회
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
	//칼라별 Product 조회
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
	//Product 상태(대여/보관)별 조회
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

	//Product 입력
	public int insert(ProductVO product) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_INSERT);// 아이디가 같은걸 찾아서 조회해라

			st.setString(1, product.getProduct_name()); // BYID 1번째 ?에서 cust_id를 넣어준다
			st.setString(2, product.getProduct_size());
			st.setString(3, product.getProduct_color());
			st.setString(4, product.getProduct_State());
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}
		return result;// customer가 채워지면 return 한다		
	}
	//Product 수정
	public int update(ProductVO product) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_UPDATE);// 아이디가 같은걸 찾아서 조회해라

			st.setString(1, product.getProduct_name()); // BYID 1번째 ?에서 cust_id를 넣어준다
			st.setString(2, product.getProduct_size());
			st.setString(3, product.getProduct_color());
			st.setString(4, product.getProduct_State());
			st.setInt(5, product.getProduct_id());
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}
		return result;// customer가 채워지면 return 한다			
	}
	
	//Product 삭제
	public int delete(int product) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_DELETE);
			st.setInt(1, product_id);
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // DB를 끊어주고 자원반납
			DBUtil.dbClose(rs, st, conn);
		}
		return result;		
	}
}
