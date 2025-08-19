package vector.CharityApp.Admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vector.CharityApp.Admin.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional <User> findByEmail(String email);



}
