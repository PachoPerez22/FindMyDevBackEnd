package cl.findmydev.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.findmydev.web.models.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}
