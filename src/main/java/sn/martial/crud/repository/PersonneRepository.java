package sn.martial.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.martial.crud.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
