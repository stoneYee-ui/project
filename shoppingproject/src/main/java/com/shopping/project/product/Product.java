package com.shopping.project.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "project_shopping_product")
public class Product {
	
	@Id 
	@SequenceGenerator(sequenceName = "project_shopping_product_seq", name = "psps", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "psps")
	@Column(name = "psp_no") // 필드명
	private Integer psp_no;
	
	@Column(name = "psp_name")
	private String psp_name;
	
	@Column(name = "psp_price")
	private Integer psp_price;
	
	@Column(name = "psp_num")
	private Integer psp_num;
	
	@Column(name = "psp_sub")
	private String psp_sub;
	
	@Column(name = "psp_photo")
	private String psp_photo;
	
}
