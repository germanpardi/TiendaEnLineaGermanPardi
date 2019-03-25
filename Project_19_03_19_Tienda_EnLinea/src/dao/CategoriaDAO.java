package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Categoria;
import interfaces.ICategoriaDAO;

public class CategoriaDAO implements ICategoriaDAO {
	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;

	public CategoriaDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Categoria findbyId(String idCategoria) {
		Categoria aux = null;
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM Categorias WHERE IDCATEGORIAS = ?");
			plantillaSQL.setString(1, idCategoria);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux = new Categoria();
				aux.setIdCategorias(resultado.getInt("idCategorias"));
				aux.setDescripcion(resultado.getString("Descripcion"));
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return aux;
	}

	@Override
	public void add(Categoria categoria) {
		try {
			plantillaSQL = con.prepareStatement("INSERT INTO Categorias VALUES (?, ?)");
			plantillaSQL.setInt(1, categoria.getIdCategorias());
			plantillaSQL.setString(2, categoria.getDescripcion());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	@Override
	public void save(Categoria categoria) {
		try {
			plantillaSQL = con.prepareStatement("UPDATE Categorias SET DESCRIPCION=? "
					+ "WHERE IDCATEGORIAS=?");
			plantillaSQL.setInt(2, categoria.getIdCategorias());
			plantillaSQL.setString(1, categoria.getDescripcion());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Vector<Categoria> list() {
		Vector<Categoria> lista = new Vector();
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM CATEGORIAS");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Categoria aux = new Categoria();
				aux.setIdCategorias(resultado.getInt("IDCATEGORIAS"));
				aux.setDescripcion(resultado.getString("descripcion"));
				lista.add(aux);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	
	}

	@Override
	public void delete(String idCategoria) {
		try {
			plantillaSQL = con.prepareStatement("DELETE FROM CATEGORIAS WHERE idCategorias=?");
			plantillaSQL.setString(1, idCategoria);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}}