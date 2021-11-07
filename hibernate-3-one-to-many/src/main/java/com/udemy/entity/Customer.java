package com.udemy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "customer_name")
	private String name;

	@Column(name = "customer_city")
	private String city;

	@Column(name = "customer_number", unique = true)
	private Long number;

	/*
	 * "mappedBy" attribute tells that Account entity is responsible for maintaining
	 * relationship i.e responsible for creating foreign-key named as "customer_id"
	 * defined in Account entity with annotation
	 * "@JoinColumn(name = "customer_id")". Also while fetching data for Account it
	 * will fetch data for Customer too.
	 */
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> accounts;

	public void addAccount(Account account) {
		if (accounts == null) {
			accounts = new ArrayList<>();
		}
		accounts.add(account);
	}

	@Override
	public String toString() {
		System.out.println("Customer Details are : ");
		System.out.println(
				" customerId : " + customerId + ", name : " + name + ", city : " + city + ", number : " + number);
		System.out.println("Account Details are : ");
		System.out.println(accounts);
		return "";
	}

}
