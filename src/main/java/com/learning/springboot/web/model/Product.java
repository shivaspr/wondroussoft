package com.learning.springboot.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    private int brands;
	
    public Product(Long id, String name, int brands) {
		super();
		this.id = id;
		this.name = name;
		this.brands = brands;
	}
    
    public Product() {
		
	}
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBrands() {
		return brands;
	}
	public void setBrands(int brands) {
		this.brands = brands;
	}
}