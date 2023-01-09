package cl.findmydev.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	// http://localhost:9080/api/hola
	@RequestMapping("/hola")
	public String hola() {
		return "hola api";
	}

	// para ruta dinámica
	// http://localhost:9080/api/edad/19
	@RequestMapping("/edad/{edad}")
	public String rutaDinamica(@PathVariable("edad") int edad) {
		return "capturando edad:" + edad;
	}

	// http://localhost:9080/api/nombre/vale
	@RequestMapping("/nombre/{nombre}")
	public String capturarNombre(@PathVariable("nombre") String nombre) {
		return "El nombre capturado es: " + nombre;
	}

	// http://localhost:9080/api/14/noviembre/2022
	@RequestMapping("/{dia}/{mes}/{año}")
	public String rutaDinamica(@PathVariable("dia") int dia, @PathVariable("mes") String mes,
			@PathVariable("año") int año) {
		return "capturando fecha: " + dia + " " + mes + " " + año;
	}

	// http://localhost:7080/api/usuario?usuarioId=1//get
	@RequestMapping("/usuario")
	public String parametro(@RequestParam(value = "usuarioId", required = false) Integer id) {
		// inr, long, float = 0
		// Integer, Float, Long pueden ser nulos
		if (id == null) {
			return "parametro no existe";
		} else {
			return "parametro por get " + id;
		}
	}

	// http://localhost:8080/api/usuario2?usuarioId=1&nombre=israel
	@RequestMapping("/usuario2")
	public String parametro2(@RequestParam(value = "usuarioId", required = false) Integer id,
			@RequestParam(value = "nombre", required = false) String nombre) {

		if (id == null) {
			return "parametro no existe";
		} else {
			return "parametro por get " + id + " nombre: " + nombre;
		}
	}

}
