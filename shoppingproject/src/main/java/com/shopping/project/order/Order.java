package com.shopping.project.order;


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
@Entity(name = "project_shopping_order")
public class Order {
	
	@Id 
	@SequenceGenerator(sequenceName = "project_shopping_order_seq", name = "pspo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pspo")
	@Column(name = "pspo_no") // 필드명
	private Integer no;
	
	@Column(name = "pspo_name")
	private String pspo_name;
	
	@Column(name = "pspo_price")
	private Integer pspo_price;
	
	@Column(name = "pspo_num")
	private Integer pspo_num;
}
