package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*; //todos los metodos static de la clase assertion

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class UsuarioTest extends SpringTest {

	@Autowired
	
	private UsuarioDao dao;
	
	@Test @Transactional @Rollback
	public void crearUsuarioYBuscarPorId() {
		
		Usuario seba = new Usuario(null, null);
		
		seba.setEmail("seba@gmail.com");
		seba.setPassword("Robertoooo");
		
		dao.guardar(seba);
		
		Usuario buscado = dao.buscarPor(seba.getId());
		
		assertThat(buscado).isNotNull();
	}
	
	@Test @Transactional @Rollback
	public void updatearUsuario() {

		Usuario seba = new Usuario(null, null);
		
		seba.setEmail("asdasd");
		
		session().save(seba);
		
		seba.setEmail("ismaelloco@gmail.com");
		
		session().update(seba);
		
		Usuario buscado = session().get(Usuario.class, seba.getId());

		assertThat(buscado.getEmail()).isEqualTo("ismaelloco@gmail.com");
	}
	
	@Test @Transactional @Rollback
	public void deleteUsuario() {

		Usuario seba = new Usuario(null, null);
		
		session().save(seba);
		
		session().delete(seba);
		
		Usuario buscado = session().get(Usuario.class, seba.getId());
		
		assertThat(buscado).isNull();
	}
	
	@Test @Transactional @Rollback
	public void buscarUsuarioPorClave() {
		
		dao.guardar(new Usuario("pedro", "1234"));
		dao.guardar(new Usuario("lucas", "1234"));
		
		List<Usuario> buscados = dao.buscarPorClave("1234");
		
		assertThat(buscados).hasSize(2);
		
	}
}