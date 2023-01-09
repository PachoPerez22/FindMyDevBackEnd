package cl.findmydev.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.findmydev.web.models.DatoContacto;

@Repository
public interface DatoContactoRepository extends JpaRepository<DatoContacto, Long> {

}
