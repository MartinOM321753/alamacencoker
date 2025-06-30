package utez.edu.mx.unidad3.models.client;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienRepository extends JpaRepository<Client, Long> {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    Client save(Client client);

    @Modifying
    @Query (value = "DELETE FROM client WHERE id =: id", nativeQuery = true )
    void deleteClientById(@Param("id") Long id);




}
