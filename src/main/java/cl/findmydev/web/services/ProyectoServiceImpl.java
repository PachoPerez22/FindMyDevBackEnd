package cl.findmydev.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.findmydev.web.models.Proyecto;
import cl.findmydev.web.repositories.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public Proyecto guardarProyecto(Proyecto proyecto) {
		return proyectoRepository.save(proyecto);
	}

	@Override
	public String eliminarProyecto(Long id) {
		Boolean existe = proyectoRepository.existsById(id);
		if (existe) {
			proyectoRepository.deleteById(id);
		} else {
			return "No existe un proyecto con esa id en la tabla  ";
		}

		existe = proyectoRepository.existsById(id);
		if (existe) {
			return "el proyecto no ah sido eliminado";
		}
		return "El proyecto ah sido eliminado Exitosamente";
	}

	// aCTUALIZAR
	@Override
	public String actualizarProyecto(Proyecto proyecto) {
		Boolean existe = proyectoRepository.existsById(proyecto.getId());

		if (existe) {
			proyectoRepository.save(proyecto);
			return " Su Proyecto se ah Actualizado Exitosamente";
		}
		return "No se ah encontrado el id del proyecto No se puede Actualizar";
	}

	// Obtener.
	@Override
	public Optional<Proyecto> obtenerProyecto(Long id) {
		Optional<Proyecto> proyect = proyectoRepository.findById(id);
		return proyect;
	}

	// tRAER TODOS LOS PROYECTOS
	@Override
	public List<Proyecto> todoProyectos() {
		return proyectoRepository.findAll();
	}
}
