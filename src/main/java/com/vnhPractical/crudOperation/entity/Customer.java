package com.vnhPractical.crudOperation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(referencedColumnName = "id")
	private Details details;

	private String accountType;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(referencedColumnName = "business_id")
	private BusinessRequirements businessRequirements;

	@NotNull(message = "contractType should be fulltime or parttime")
	private String contractType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BusinessRequirements getBusinessRequirements() {
		return businessRequirements;
	}

	public void setBusinessRequirements(BusinessRequirements businessRequirements) {
		this.businessRequirements = businessRequirements;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", details=" + details + ", accountType=" + accountType
				+ ", businessRequirements=" + businessRequirements + ", contractType=" + contractType + "]";
	}

	public Customer(int id, String name, Details details, String accountType, BusinessRequirements businessRequirements,
			String contractType) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.accountType = accountType;
		this.businessRequirements = businessRequirements;
		this.contractType = contractType;
	}

}
