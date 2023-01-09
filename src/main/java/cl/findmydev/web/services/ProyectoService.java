package cl.findmydev.web.services;

import java.util.List;
import java.util.Optional;

import cl.findmydev.web.models.Proyecto;

public interface ProyectoService {

	public Proyecto guardarProyecto(Proyecto proyecto);

	// eliminar un proyecto
	public String eliminarProyecto(Long id); // string ya que no retorna nada mas que un mensaje !!

	// Actualizar Proyecto
	public String actualizarProyecto(Proyecto proyecto);

	// Para obtener un proyecto

	public Optional<Proyecto> obtenerProyecto(Long id);

	// Obtener todos los proyectos

	public List<Proyecto> todoProyectos();
}
