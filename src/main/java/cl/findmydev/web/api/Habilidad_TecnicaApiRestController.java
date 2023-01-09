package cl.findmydev.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.findmydev.web.models.Habilidad_Tecnica;
import cl.findmydev.web.services.Habilidad_TecnicaServiceImpl;

@RestController
public class Habilidad_TecnicaApiRestController {
	@Autowired
	private Habilidad_TecnicaServiceImpl habilidad_tecnicaServiceImpl;

	// http://localhost:8080/guardar/habilidad_tecnica
	@RequestMapping("/guardar/habilidad_tecnica")
	public Habilidad_Tecnica guardarhabilidad_tecnica(@RequestBody Habilidad_Tecnica habilidad_tecnica) {
		return habilidad_tecnicaServiceImpl.guardarHabilidad_Tecnica(habilidad_tecnica);
	}

	// eliminar
	@RequestMapping("/eliminar/habilidad_tecnica")
	public String eliminarHabilidad_Tecnica(@RequestParam(value = "id", required = true) Long id) {
		return habilidad_tecnicaServiceImpl.eliminarHabilidad_Tecnica(id);
	}

	// actualizar
	@RequestMapping("/actualizar/habilidad_tecnica")
	public String obtenerHabilidadTecnica(@RequestBody Habilidad_Tecnica habilidad_tecnica) {
		if (habilidad_tecnica.getId() != null) {
			String mensaje = habilidad_tecnicaServiceImpl.actualizarHabilidad_Tecnica(habilidad_tecnica);
			return mensaje;
		}
		return "No se puede actualizar si no ah sido creada";
	}

	// Traer una habilidad tecnica en especifico
	@RequestMapping("/obtener/habilidad_Tecnica")
	public Optional<Habilidad_Tecnica> obtenerHabilidad_Tecnica(@RequestParam(value = "id", required = true) Long id) {
		return habilidad_tecnicaServiceImpl.obtenerHabilidad_Tecnica(id);
	}

	// Traer todas las habilidades
	@RequestMapping("/lista/habilidades_tecnicas")
	public List<Habilidad_Tecnica> todoHabilidadTecnica() {
		return habilidad_tecnicaServiceImpl.TodoHabilidadTecnica();
	}

}
