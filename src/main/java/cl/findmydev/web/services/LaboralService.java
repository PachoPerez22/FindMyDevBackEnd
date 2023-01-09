package cl.findmydev.web.services;

import java.util.List;

import cl.findmydev.web.models.Laboral;

public interface LaboralService {

	public Laboral guardarLaboral(Laboral laboral);

	public String eliminarLaboral(Long id);

	public Laboral actualizarLaboral(Laboral laboral);

	public Laboral obtenerLaboral(Long id);

	public List<Laboral> obtenerListaLaboral();
}