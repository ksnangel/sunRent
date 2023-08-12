package com.rent.dto;

import java.sql.Date;

public class RentVO {
	private int rent_id ;
	private int  cust_id ;
	private int  product_id ;
	private Date rent_date ;
	private Date return_date ;
	
	public RentVO() {
		super();
	}
	public RentVO(int rent_id, int cust_id, int product_id, Date rent_date, Date return_date) {
		super();
		this.rent_id = rent_id;
		this.cust_id = cust_id;
		this.product_id = product_id;
		this.rent_date = rent_date;
		this.return_date = return_date;
	}

	public int getRent_id() {
		return rent_id;
	}

	public void setRent_id(int rent_id) {
		this.rent_id = rent_id;
	}


	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public Date getRent_date() {
		return rent_date;
	}

	public void setRent_date(Date rent_date) {
		this.rent_date = rent_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}


	@Override
	public String toString() {
		return "RentVO [rent_id=" + rent_id + ", cust_id=" + cust_id + ", product_id=" + product_id + ", rent_date="
				+ rent_date + ", return_date=" + return_date + "]";
	}
	
	
	
	
    }
