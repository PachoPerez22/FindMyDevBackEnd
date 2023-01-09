package cl.findmydev.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.findmydev.web.models.Laboral;

@Repository
public interface LaboralRepository extends JpaRepository<Laboral, Long>{

}
