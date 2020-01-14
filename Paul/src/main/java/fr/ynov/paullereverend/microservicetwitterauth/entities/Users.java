package fr.ynov.paullereverend.microservicetwitterauth.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "password")
	private String id;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "pseudoTwitter")
	private String pseudoTwitter;
	
	@Column(name = "tokenTwitter")
	private Date tokenTwitter;
	
}
