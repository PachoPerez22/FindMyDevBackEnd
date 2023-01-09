package cl.findmydev.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.findmydev.web.models.Academica;
import cl.findmydev.web.services.AcademicaServiceImpl;

@RestController
public class AcademicaApiRestController {
	@Autowired
	private AcademicaServiceImpl academicaServiceImpl;

	// http://localhost:8080/guardar/academica
	@RequestMapping("/guardar/academica")
	public Academica guardarAcademica(@RequestBody Academica academica) {
		return academicaServiceImpl.guardarAcademica(academica);
	}

	// http://localhost:8080/eliminar/academica
	@RequestMapping("/eliminar/academica")
	public String eliminarAcademica(@RequestParam(value = "id", required = false) Long id) {
		return academicaServiceImpl.eliminarAcademica(id);
	}

	// http://localhost:8080/actualizar/academica
	@RequestMapping("/actualizar/academica")
	public Academica actualizarAcademica(@RequestBody Academica academica) {
		Academica mensaje = academicaServiceImpl.actualizarAcademica(academica);
		return mensaje;

	}

	// http://localhost:8080/obtener/usuario
	@RequestMapping("/obtener/academica")
	public Academica obtenerAcademica(@RequestParam(value = "id", required = true) Long id) {

		return academicaServiceImpl.obtenerAcademica(id);
	}

	// http://localhost:8080/listar/academica
	@GetMapping("/listar/academica")
	public List<Academica> obtenerListaAcademica() {
		return academicaServiceImpl.obtenerListaAcademica();
	}
//>>>>>>> 80e546087a919492b47a08dade5719e63a70e005
}
