package com.example.demo.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	@Id
	private Long id;
	@NotBlank(message = "Name must not be empty")
	private String name;
	@NotBlank(message = "Password must not be empty")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@NotBlank(message = "Email must not be empty")
	@Email
	private String email;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}

	
}
