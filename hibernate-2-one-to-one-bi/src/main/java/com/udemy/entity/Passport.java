package com.udemy.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passport {

	@Id
	@Column(name = "passport_number")
	private String passportNumber;

	@Column(name = "passport_type")
	private String passportType;

	@Temporal(TemporalType.DATE)
	@Column(name = "passport_issue_on")
	private Date passportIssueOn;

	@Temporal(TemporalType.DATE)
	@Column(name = "passport_valid_to")
	private Date passportValidTo;

	/*
	 * "mappedBy" attribute tells that Person entity is responsible for maintaining
	 * relationship i.e responsible for creating foreign-key named as
	 * "passport_number" defined in Person entity with annotation
	 * "@JoinColumn(name = "passport_number")". Also while fetching data for
	 * Passport it will fetch data for Person too.
	 */
	@OneToOne(mappedBy = "passport", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
	private Person person;

	@Override
	public String toString() {
		return "Passport [passportNumber=" + passportNumber + ", passportType=" + passportType + ", passportIssueOn="
				+ passportIssueOn + ", passportValidTo=" + passportValidTo + ", firstName=" + person.getFirstName()
				+ ", lastName=" + person.getLastName() + ", city=" + person.getCity() + "]";
	}

}
