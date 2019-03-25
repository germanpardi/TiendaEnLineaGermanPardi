package interfaces;

import java.util.Vector;

import beans.Producto;
import beans.Usuario;

public interface IUsuarioDAO {
	public Usuario findbyId(String idUsuario);
	public void add(Usuario usuario);
	public void save(Usuario usuario); 
	public Vector<Usuario> list();
    public void delete(String idUsuario);
    public Vector<Usuario> lista_productos(String descripcionProducto);
    public Vector<Usuario> lista_por_categoria(String descripcionCategoria);
		
}
