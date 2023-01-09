package cl.findmydev.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.findmydev.web.models.Reclutador;

@Repository
public interface ReclutadorRepository extends JpaRepository<Reclutador,Long> {


}
