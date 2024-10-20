package com.sarvika.technologies.assignment.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "products")
public class Product {
	
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer quantityAvailable;
	private String category;
}
