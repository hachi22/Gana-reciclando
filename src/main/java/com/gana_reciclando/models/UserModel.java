package com.gana_reciclando.models;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="user")
public class UserModel {
	@Id
	private String username;
	
	private String password;
	
	private int points_game1 = 0;
	
	private int points_game2 = 0;
	
	private int points_game3 = 0;
	
	
	public UserModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	
}
