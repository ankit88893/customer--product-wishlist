package com.dxctraining.customermgt.customer.entities;

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	public Customer() {

	}

	public Customer(String name) {
		this.name = name;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Customer that = (Customer) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;

	}
}
