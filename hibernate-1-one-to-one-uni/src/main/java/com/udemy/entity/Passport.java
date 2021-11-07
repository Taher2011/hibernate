package com.udemy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
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

}
