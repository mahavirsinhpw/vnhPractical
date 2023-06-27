package com.vnhPractical.crudOperation.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class BusinessRequirements {

	@Id
	@GeneratedValue
	private int business_id;

	private List<String> business;

	public int getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}

	public List<String> getBusiness() {
		return business;
	}

	public void setBusiness(List<String> business) {
		this.business = business;
	}

	public BusinessRequirements() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessRequirements(int business_id, List<String> business) {
		super();
		this.business_id = business_id;
		this.business = business;
	}

	@Override
	public String toString() {
		return "BusinessRequirements [business_id=" + business_id + ", business=" + business + "]";
	}

}
