package pt.ua.data_jpa_app.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt.ua.data_jpa_app.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
