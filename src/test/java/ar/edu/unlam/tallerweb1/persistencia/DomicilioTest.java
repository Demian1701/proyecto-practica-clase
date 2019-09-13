package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.dao.DomicilioDao;
import ar.edu.unlam.tallerweb1.modelo.Domicilio;

import static org.assertj.core.api.Assertions.*; //todos los metodos static de la clase assertion

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;

public class DomicilioTest extends SpringTest {

	@Autowired
	private DomicilioDao dao;

	@Test
	@Transactional
	@Rollback
	public void domiciliosEnPeru() {

		dao.guardar(new Domicilio("dorrego", "869", "San Justo", "1234"));
		dao.guardar(new Domicilio("peru", "469", "San Justo", "54"));
		dao.guardar(new Domicilio("roberto", "123", "Ramos Mejia", "234"));

		List<Domicilio> buscados = dao.buscarDomicilioPorCalle("peru");

		assertThat(buscados).hasSize(1);

	}

}
