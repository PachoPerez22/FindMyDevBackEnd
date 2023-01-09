package cl.findmydev.web.services;

import java.util.List;
import java.util.Optional;

import cl.findmydev.web.models.Habilidad_Tecnica;

public interface Habilidad_TecnicaService {

	public Habilidad_Tecnica guardarHabilidad_Tecnica(Habilidad_Tecnica habilidad_tecnica);

	public String eliminarHabilidad_Tecnica(Long id);

	public String actualizarHabilidad_Tecnica(Habilidad_Tecnica habilidad_tecnica);

	public Optional<Habilidad_Tecnica> obtenerHabilidad_Tecnica(Long id);

	public List<Habilidad_Tecnica> TodoHabilidadTecnica();
}
