package com.gana_reciclando.models;

import javax.persistence.Entity;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class UserModel {
	@Id
	private String userName;
	
	private String password;
	
	private int pointsGame1 = 0;
	
	private int pointsGame2 = 0;
	
	private int pointsGame3 = 0;
	
	
	public UserModel(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	
	
}
