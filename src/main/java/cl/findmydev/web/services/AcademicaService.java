package cl.findmydev.web.services;

import java.util.List;

import cl.findmydev.web.models.Academica;

public interface AcademicaService {

	public Academica guardarAcademica(Academica academica);

	public String eliminarAcademica(Long id);

	public Academica actualizarAcademica(Academica academica);

	public Academica obtenerAcademica(Long id);

	public List<Academica> obtenerListaAcademica();
}
