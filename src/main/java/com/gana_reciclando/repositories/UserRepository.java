package com.gana_reciclando.repositories;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.gana_reciclando.models.UserObject;

@Repository
public interface UserRepository extends CrudRepository<UserObject,String>{
}
