package cl.findmydev.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.findmydev.web.models.Academica;

@Repository
public interface AcademicaRepository extends JpaRepository<Academica, Long>{

}
