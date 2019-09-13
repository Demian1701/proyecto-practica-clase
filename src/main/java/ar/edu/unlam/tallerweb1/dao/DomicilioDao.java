package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;

public interface DomicilioDao {
	
	Domicilio buscarDomicilio(Domicilio domicilio);
	public List<Domicilio> buscarDomicilioPorCalle(String calle);
	public List<Domicilio> buscarSanJusto(String barrio);
	public List<Domicilio> buscarNumeroCalle(String numero1, String numero2);
	public List<Domicilio> buscarSanjustoOrRamosMejia(String barrio1, String barrio2);
	public void guardar(Domicilio domicilio);

}
