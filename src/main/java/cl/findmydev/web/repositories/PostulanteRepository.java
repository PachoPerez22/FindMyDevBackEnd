package cl.findmydev.web.repositories;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import cl.findmydev.web.models.Postulante;

@Repository
public interface PostulanteRepository extends JpaRepository<Postulante, Long> {

	//@Query("SELECT p FROM Postulante p WHERE p.habilidad_blanda.id=?1")
//	List<Postulante> buscarPorHabilidadBlanda(Long id);
}
