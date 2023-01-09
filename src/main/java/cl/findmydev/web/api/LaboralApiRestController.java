package cl.findmydev.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.findmydev.web.models.Laboral;
import cl.findmydev.web.services.LaboralServiceImpl;

@RestController
public class LaboralApiRestController {
	@Autowired
	private LaboralServiceImpl laboralServiceImpl;

	// http://localhost:8080/guardar/laboral
	@RequestMapping("/guardar/laboral")
	public Laboral guardarLaboral(@RequestBody Laboral laboral) {
		return laboralServiceImpl.guardarLaboral(laboral);
	}

	// http://localhost:8080/eliminar/academica
	@RequestMapping("/eliminar/laboral")
	public String eliminarLaboral(@RequestParam(value = "id", required = false) Long id) {
		return laboralServiceImpl.eliminarLaboral(id);
	}

	// http://localhost:8080/actualizar/academica
	@RequestMapping("/actualizar/Laboral")
	public Laboral actualizarLaboral(@RequestBody Laboral laboral) {
		Laboral mensaje = laboralServiceImpl.actualizarLaboral(laboral);
		return mensaje;

	}

	// http://localhost:8080/obtener/usuario
	@RequestMapping("/obtener/Laboral")
	public Laboral obtenerLaboral(@RequestParam(value = "id", required = true) Long id) {

		return laboralServiceImpl.obtenerLaboral(id);
	}

	// http://localhost:8080/listar/academica
	@GetMapping("/listar/laboral")
	public List<Laboral> obtenerListaLaboral() {
		return laboralServiceImpl.obtenerListaLaboral();
	}
}