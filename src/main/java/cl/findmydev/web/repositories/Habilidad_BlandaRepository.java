package cl.findmydev.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.findmydev.web.models.Habilidad_Blanda;

@Repository
public interface Habilidad_BlandaRepository extends JpaRepository<Habilidad_Blanda, Long>{

	
}
