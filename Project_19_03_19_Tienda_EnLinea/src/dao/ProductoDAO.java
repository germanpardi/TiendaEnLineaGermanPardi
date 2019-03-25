package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Producto;
import beans.Usuario;
import interfaces.IProductoDAO;

public class ProductoDAO implements IProductoDAO {

	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;

	public ProductoDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Producto findbyId(int id_producto) {
		Producto aux = null;
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM PRODUCTO WHERE ID_PRODUCTO = ?");
			plantillaSQL.setInt(1, id_producto);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux = new Producto();
				aux.setId_producto(resultado.getInt("ID_PRODUCTO"));
				aux.setIdCategorias(resultado.getInt("idCategorias"));
				aux.setDescripcion(resultado.getString("Descripcion"));
				aux.setPrecio(resultado.getDouble("PRECIO"));
				aux.setStock(resultado.getInt("STOCK"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return aux;
	}

	@Override
	public void add(Producto producto) {
		try {
			plantillaSQL = con.prepareStatement("INSERT INTO producto VALUES (?, ?, ?, ?, ?)");
			plantillaSQL.setInt(1, producto.getId_producto());
			plantillaSQL.setInt(2, producto.getIdCategorias());
			plantillaSQL.setString(3, producto.getDescripcion());
			plantillaSQL.setDouble(4, producto.getPrecio());
			plantillaSQL.setInt(5, producto.getStock());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

	@Override
	public void save(Producto producto) {
		try {
			plantillaSQL = con
					.prepareStatement("UPDATE PRODUCTO SET IDCATEGORIAS=?, DESCRIPCION = ? ,PRECIO = ? , STOCK = ?  " + "WHERE ID_PRODUCTO=?");
			plantillaSQL.setInt(1, producto.getIdCategorias());
			plantillaSQL.setString(2, producto.getDescripcion());
			plantillaSQL.setDouble(3, producto.getPrecio());
			plantillaSQL.setInt(4, producto.getStock());
			plantillaSQL.setInt(5, producto.getId_producto());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Producto> list() {
		Vector<Producto> lista = new Vector();
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM PRODUCTO");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Producto aux = new Producto();
				aux.setId_producto(resultado.getInt("ID_PRODUCTO"));
				aux.setIdCategorias(resultado.getInt("IDCATEGORIAS"));
				aux.setDescripcion(resultado.getString("DESCRIPCION"));
				aux.setPrecio(resultado.getInt("PRECIO"));
				aux.setStock(resultado.getInt("STOCK"));
				lista.add(aux);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;

	}

	@Override
	public void delete(int id_producto) {
		try {
			plantillaSQL = con.prepareStatement("DELETE FROM PRODUCTO WHERE id_producto=?");
			plantillaSQL.setInt(1, id_producto);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Producto> list(String descripcionCategoria) {
		Vector<Producto> lista = new Vector();
		try {
			plantillaSQL = con.prepareStatement("SELECT p.id_producto, p.descripcion, p.precio, p.stock\r\n" + 
					"FROM producto  p\r\n" + 
					"INNER JOIN categorias c ON  c.idcategorias = p.idcategorias\r\n" + 
					"where c.descripcion = ?");
			
			plantillaSQL.setString(1, descripcionCategoria);
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Producto aux = new Producto();
				aux.setId_producto(resultado.getInt("p.ID_PRODUCTO"));
				aux.setDescripcion(resultado.getString("p.descripcion"));
				aux.setPrecio(resultado.getDouble(3));
				aux.setStock(resultado.getInt(4));
				lista.add(aux);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;

	}

	
	
	
	

}
