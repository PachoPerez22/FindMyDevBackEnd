package cl.findmydev.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.findmydev.web.models.DatoEmpresa;

@Repository
public interface DatoEmpresaRepository extends JpaRepository<DatoEmpresa, Long> {

}
