package com.vnhPractical.crudOperation.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Details {

	@Id
	@GeneratedValue
	private int id;

	private String sex;

	private LocalDate dob;

	private String nativ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getNativ() {
		return nativ;
	}

	public void setNativ(String nativ) {
		this.nativ = nativ;
	}

	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Details [id=" + id + ", sex=" + sex + ", dob=" + dob + ", nativ=" + nativ + "]";
	}

	public Details(int id, @NotNull(message = "Sex should be “M” or “F”") String sex,
			@NotBlank(message = "DOB should be < 01-01-2002") LocalDate dob, String nativ) {
		super();
		this.id = id;
		this.sex = sex;
		this.dob = dob;
		this.nativ = nativ;
	}

}
