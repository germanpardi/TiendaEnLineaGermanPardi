package interfaces;

import java.util.Vector;


import beans.Usuario;

public interface IUsuarioSERVICE {
	
	public Vector<Usuario> listarusuarios();
	public Usuario buscarnombre(String idUsuarios);
	public void borrarnombre(String idUsuarios);
	public void altausuario(Usuario usuario);
	public void modificarusuario(Usuario usuario);
	public Vector<Usuario> listado_usuarios_compraron_producto(String descripcionProducto);
	public Vector<Usuario> listado_usuarios_compraron_por_categoria(String descripcionCategoria);
	

}
