package com.sarvika.technologies.assignment.model;

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
public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
}
