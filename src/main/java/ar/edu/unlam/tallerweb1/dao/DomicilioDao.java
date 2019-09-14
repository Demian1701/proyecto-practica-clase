package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;

public interface DomicilioDao {
	
	Domicilio buscarDomicilio(Domicilio domicilio);
	public List<Domicilio> buscarDomiciliosPorCalle(String calle);
	public List<Domicilio> buscarDomiciliosPorBarrio(String barrio);
	public List<Domicilio> buscarDomiciliosPorCalleYNumero(String calle, Integer numero1, Integer numero2);
	public List<Domicilio> buscarDomiciliosPorBarrios(String barrio1, String barrio2);
	public void guardar(Domicilio domicilio);

}
