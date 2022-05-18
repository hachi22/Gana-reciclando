package gana_reciclando.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gana_reciclando.models.UserModel;
import gana_reciclando.repositories.UserRepository;

@Service
public class UserService {
	
	 @Autowired
	    private UserRepository userRepository;

	    
	    public UserModel putUser(UserModel user){
	        //user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	        userRepository.save(user);
	        return user;}


	    public UserModel checkUsername(String username){
	        return userRepository.findById(username).orElse(null);
	    }

	    public String passwordEncoder(String pass) {
	        return new BCryptPasswordEncoder().encode(pass);
	    }
}
