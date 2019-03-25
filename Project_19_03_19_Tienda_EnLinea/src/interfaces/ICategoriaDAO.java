package interfaces;

import java.util.Vector;
import beans.Categoria;;

public interface ICategoriaDAO {
	public Categoria findbyId(String idCategoria);
	public void add(Categoria categoria);
	public void save(Categoria categoria); 
	public Vector<Categoria> list();
    public void delete(String idCategoria);
		
}