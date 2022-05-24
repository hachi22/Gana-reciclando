package com.gana_reciclando.services;


import java.util.Collection;


import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.gana_reciclando.models.UserObject;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	 @Autowired
	 UserService userService;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  UserObject user = userService.checkUsername(username);
	       User.UserBuilder builder;

	        if(user!=null){
	            builder=User.withUsername(username);
	            builder.disabled(false);
	            builder.password(user.getPassword());
	            builder.roles("USER");
	        }
	        else throw new UsernameNotFoundException("User dont found");
	        return builder.build();
	    }
	    
	}

	


