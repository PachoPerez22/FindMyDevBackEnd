package cl.findmydev.web.services;

import java.util.List;
import java.util.Optional;

import cl.findmydev.web.models.DatoEmpresa;

public interface DatoEmpresaService {

	public DatoEmpresa guardarDatoEmpresa(DatoEmpresa datoEmpresa);

	public String eliminarDatoEmpresa(Long id);

	public String actualizarDatoEmpresa(DatoEmpresa datoEmpresa);

	public List<DatoEmpresa> listarDatoEmpresas();

	public Optional<DatoEmpresa> obtenerEmpresa(Long id);

}
