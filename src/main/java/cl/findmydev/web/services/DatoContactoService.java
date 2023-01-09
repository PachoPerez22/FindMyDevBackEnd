package cl.findmydev.web.services;

import cl.findmydev.web.models.DatoContacto;

public interface DatoContactoService {

	public DatoContacto guardarDatoContacto(DatoContacto datoContacto);

	public String eliminarDatoContacto(Long id);

	public String actualizarDatoContacto(DatoContacto datoContacto);

	public DatoContacto obtenerDatoContacto(Long id);
}
