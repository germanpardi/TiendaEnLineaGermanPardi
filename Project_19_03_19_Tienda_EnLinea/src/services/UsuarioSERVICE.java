package services;

import java.util.Vector;

import beans.Usuario;
import interfaces.IUsuarioDAO;
import interfaces.IUsuarioSERVICE;
import util.TransactionManager;

public class UsuarioSERVICE implements IUsuarioSERVICE {

	@Override
	public Vector<Usuario> listarusuarios() {
		// TODO Auto-generated method stub
		TransactionManager manager = new TransactionManager();
		IUsuarioDAO usuariodao = manager.getUsuarioDAO();
		Vector<Usuario> usuarios =  usuariodao.list();
		manager.cerrarconexion();
		
		return usuarios;
	}
	
	@Override
	public Usuario buscarnombre(String id_usuario) {
		// TODO Auto-generated method stub
		TransactionManager manager = new TransactionManager();
		IUsuarioDAO usuariodao = manager.getUsuarioDAO();
		Usuario usuarios= usuariodao.findbyId(id_usuario);
		manager.cerrarconexion();
		
		return usuarios;
	}
	public void borrarnombre(String id_usuario) {
		TransactionManager manager = new TransactionManager();
		IUsuarioDAO usuariodao = manager.getUsuarioDAO();
		usuariodao.delete(id_usuario);
		manager.cerrarconexion();
	}

	@Override
	public void altausuario(Usuario usuario) {
		TransactionManager manager = new TransactionManager();
		IUsuarioDAO usuariodao = manager.getUsuarioDAO();
		usuariodao.add(usuario);
		manager.cerrarconexion();
		
	}

	@Override
	public void modificarusuario(Usuario usuario) {
		TransactionManager manager = new TransactionManager();
		IUsuarioDAO usuariodao = manager.getUsuarioDAO();
		usuariodao.save(usuario);
		manager.cerrarconexion();
		
	}

	@Override
	public Vector<Usuario> listado_usuarios_compraron_producto(String descripcionProducto) {
		TransactionManager manager = new TransactionManager();
		IUsuarioDAO usuariodao = manager.getUsuarioDAO();
		Vector<Usuario> usuarios =  usuariodao.lista_productos(descripcionProducto);
		manager.cerrarconexion();
		
		return usuarios;
	}

	@Override
	public Vector<Usuario> listado_usuarios_compraron_por_categoria(String descripcionCategoria) {
		TransactionManager manager = new TransactionManager();
		IUsuarioDAO usuariodao = manager.getUsuarioDAO();
		Vector<Usuario> usuarios =  usuariodao.lista_por_categoria(descripcionCategoria);
		manager.cerrarconexion();
		
		return usuarios;
	}

	//USUARIOS QUE HAN COMPRADO MOVILES

}
