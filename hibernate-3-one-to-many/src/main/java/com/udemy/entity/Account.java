package com.udemy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Integer accountId;

	@Column(name = "account_number", unique = true)
	private String accountNumber;

	@Column(name = "account_type")
	private String type;

	@Temporal(TemporalType.DATE)
	@Column(name = "account_create_on")
	private Date createOn;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Override
	public String toString() {
		System.out.println("accountId : " + accountId + ", accountNumber : " + accountNumber + ", type : " + type
				+ ", createOn : " + createOn);
		return "";
	}

}
