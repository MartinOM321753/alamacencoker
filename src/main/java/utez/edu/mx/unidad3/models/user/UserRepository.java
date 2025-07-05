package utez.edu.mx.unidad3.models.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<BeanUser,Integer> {


    Optional<BeanUser> findByUsernameAndPaswor(String username, String password);

    Optional<BeanUser> findByUsername(String username);

    Optional<BeanUser> findById();

}
