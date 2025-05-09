package com.admin.configuration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "admin_user") // Specifying the table name
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Username must not be null")
	@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	private String username;

	@NotNull(message = "Email must not be null")
	@Email(message = "Invalid email format")
	@Size(max = 100, message = "Email must be less than or equal to 100 characters")
	private String email;

	@NotNull(message = "Role must not be null")
	@ManyToOne
	private Role role;
	@NotNull(message = "Password must not be null")
	@Size(min = 8, max = 30, message = "password must be between 6 and 30 characters")
	private String password;

	private Boolean isNewUser = false;
}
