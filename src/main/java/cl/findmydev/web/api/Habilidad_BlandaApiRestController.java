package cl.findmydev.web.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.findmydev.web.models.Habilidad_Blanda;
import cl.findmydev.web.services.Habilidad_BlandaServiceImpl;

@RestController
public class Habilidad_BlandaApiRestController {

	@Autowired
	private Habilidad_BlandaServiceImpl habilidad_BlandaServiceImpl;

	// http://localhost:8080/guardar/habilidad_Blanda
	@RequestMapping("/guardar/habilidad_Blanda")
	public Habilidad_Blanda guardarHabilidad_Blanda(@RequestBody Habilidad_Blanda habilidad_Blanda) {
		return habilidad_BlandaServiceImpl.guardarHabilidad_Blanda(habilidad_Blanda);
	}

	// http://localhost:8080/eliminar/academica
	@RequestMapping("/eliminar/habilidad_Blanda")
	public String eliminarHabilidad_Blanda(@RequestParam(value = "id", required = false) Long id) {
		return habilidad_BlandaServiceImpl.eliminarHabilidad_Blanda(id);
	}

	// http://localhost:8080/actualizar/academica
	@RequestMapping("/actualizar/habilidad_Blanda")
	public Habilidad_Blanda actualizarHabilidad_Blanda(@RequestBody Habilidad_Blanda habilidad_Blanda) {
		Habilidad_Blanda mensaje = habilidad_BlandaServiceImpl.actualizarHabilidad_Blanda(habilidad_Blanda);
		return mensaje;

	}

	// http://localhost:8080/obtener/usuario
	@RequestMapping("/obtener/habilidad_Blanda")
	public Habilidad_Blanda obtenerHabilidad_Blanda(@RequestParam(value = "id", required = true) Long id) {

		return habilidad_BlandaServiceImpl.obtenerHabilidad_Blanda(id);
	}

	// http://localhost:8080/listar/academica
	@GetMapping("/listar/habilidad_Blanda")
	public List<Habilidad_Blanda> obtenerListaAcademica() {
		return habilidad_BlandaServiceImpl.obtenerListaHabilidad_Blanda();
	}
}
