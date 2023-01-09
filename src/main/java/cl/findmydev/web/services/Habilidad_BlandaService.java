package cl.findmydev.web.services;

import java.util.List;

import cl.findmydev.web.models.Habilidad_Blanda;

public interface Habilidad_BlandaService {

	public Habilidad_Blanda guardarHabilidad_Blanda(Habilidad_Blanda habilidad_Blanda);

	public String eliminarHabilidad_Blanda(Long id);

	public Habilidad_Blanda actualizarHabilidad_Blanda(Habilidad_Blanda habilidad_Blanda);

	public Habilidad_Blanda obtenerHabilidad_Blanda(Long id);

	public List<Habilidad_Blanda> obtenerListaHabilidad_Blanda();
}
