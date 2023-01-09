package cl.findmydev.web.services;

import java.util.List;

import cl.findmydev.web.models.Postulante;

public interface PostulanteService {

	public Postulante guardarPostulante(Postulante postulante);

	public String eliminarPostulante(Long id);

	public String actualizarPostulante(Postulante postulante);

	public Postulante obtenerPostulante(Long id);
	
	public List<Postulante> listaPostulantes();
	
	//public List<Postulante> buscarPorHabilidadBlanda(Long id);
}
