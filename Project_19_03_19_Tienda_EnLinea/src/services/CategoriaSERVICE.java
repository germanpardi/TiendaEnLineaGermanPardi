package services;

import java.util.Vector;

import beans.Categoria;
import interfaces.ICategoriaDAO;
import interfaces.ICategoriaSERVICE;
import util.TransactionManager;

public class CategoriaSERVICE implements ICategoriaSERVICE {

	@Override
	public Vector<Categoria> listarcategorias() {
		TransactionManager manager = new TransactionManager();
		ICategoriaDAO categoriaDAO = manager.getCategoriaDAO();
		Vector<Categoria> categorias = categoriaDAO.list();
		manager.cerrarconexion();

		return categorias;

	}

	@Override
	public Categoria buscarnombre(String idCategoria) {

		TransactionManager manager = new TransactionManager();
		ICategoriaDAO categoriaDAO = manager.getCategoriaDAO();
		Categoria categoria = categoriaDAO.findbyId(idCategoria);
		manager.cerrarconexion();

		return categoria;
	}

	@Override
	public void borrarnombre(String idCategoria) {
		TransactionManager manager = new TransactionManager();
		ICategoriaDAO categoriaDAO = manager.getCategoriaDAO();
		categoriaDAO.delete(idCategoria);
		manager.cerrarconexion();

	}

	@Override
	public void altausuario(Categoria categoria) {
		TransactionManager manager = new TransactionManager();
		ICategoriaDAO categoriaDAO = manager.getCategoriaDAO();
		categoriaDAO.add(categoria);
		manager.cerrarconexion();

	}

	@Override
	public void modificarusuario(Categoria categoria) {
		TransactionManager manager = new TransactionManager();
		ICategoriaDAO categoriaDAO = manager.getCategoriaDAO();
		categoriaDAO.save(categoria);
		manager.cerrarconexion();

	}

}
