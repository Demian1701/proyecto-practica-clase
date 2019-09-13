package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
	public void guardar(Usuario user);
	public Usuario buscarPor(Long id);
	public List<Usuario> buscarPorClave(String clave);
}
