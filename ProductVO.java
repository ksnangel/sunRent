package com.rent.dto;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProductVO {
	private int product_id ;
	private String product_name ;
	private String product_size ;
	private String product_color ;
	private String product_State ;
	
	public ProductVO() {
		super();

	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_size() {
		return product_size;
	}

	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}

	public String getProduct_color() {
		return product_color;
	}

	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}

	public String getProduct_State() {
		return product_State;
	}

	public void setProduct_State(String product_State) {
		this.product_State = product_State;
	}

	public ProductVO(int product_id, String product_name, String product_size, String product_color,
			String product_State) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_size = product_size;
		this.product_color = product_color;
		this.product_State = product_State;
	}

	@Override
	public String toString() {
		return "ProductVO [product_id=" + product_id + ", product_name=" + product_name + ", product_size="
				+ product_size + ", product_color=" + product_color + ", product_State=" + product_State + "]";
	}
}
