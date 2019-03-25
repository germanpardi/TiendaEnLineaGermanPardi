package interfaces;

import java.util.Vector;

import beans.Categoria;

public interface ICategoriaSERVICE {
	
	public Vector<Categoria> listarcategorias();
	public Categoria buscarnombre(String idCategoria);
	public void borrarnombre(String idCategoria);
	public void altausuario(Categoria categoria);
	public void modificarusuario(Categoria categoria);
	

}
