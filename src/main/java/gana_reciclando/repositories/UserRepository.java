package gana_reciclando.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gana_reciclando.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel,String>{

}
