package utez.edu.mx.unidad3.models.cede;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CedeRepository extends JpaRepository<Cede, Long> {
    List<Cede> findAll();
    Cede save(Cede cede);
    Optional<Cede> findById(Long id);
    @Modifying
    @Query (value = "DELETE FROM cede WHERE id =: id", nativeQuery = true )
    void deleteCedeById(@Param("id") Long id);

}
