package com.shopping.project.member;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "project_shopping_member")
public class Member {
	
	@Id 
	@Column(name = "psm_id")
	private String psm_id;
	
	@Column(name = "psm_pw")
	private String psm_pw;
	
	@Column(name = "psm_name")
	private String psm_name;
	
	@Column(name = "psm_address")
	private String psm_address;
	
	@Column(name = "psm_birthday")
	private Date psm_birthday;
}
