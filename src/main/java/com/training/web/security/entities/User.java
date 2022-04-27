package com.training.web.security.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="dao_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private long id;
	private String username;
	private String password;
	private String role;

}
