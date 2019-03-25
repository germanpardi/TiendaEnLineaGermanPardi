package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Producto;
import beans.Usuario;

import interfaces.IUsuarioDAO;

public class UsuarioDAO implements IUsuarioDAO {
	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;

	public UsuarioDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Usuario findbyId(String id_usuario) {
		Usuario aux = null;
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM Usuarios WHERE ID_USUARIO = ?");
			plantillaSQL.setString(1, id_usuario);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux = new Usuario();
				aux.setId_usuario(resultado.getString("id_usuario"));
				aux.setPassword(resultado.getString("password"));
				aux.setEmail(resultado.getString("email"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return aux;
	}

	@Override
	public void add(Usuario usuario) {
		try {
			plantillaSQL = con.prepareStatement("INSERT INTO usuarios VALUES (?, ?, ?)");
			plantillaSQL.setString(1, usuario.getId_usuario());
			plantillaSQL.setString(2, usuario.getPassword());
			plantillaSQL.setString(3, usuario.getEmail());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

	@Override
	public void save(Usuario usuario) {
		try {
			plantillaSQL = con.prepareStatement("UPDATE USUARIOS SET PASSWORD=?, EMAIL = ? "
					+ "WHERE ID_USUARIO=?");
			plantillaSQL.setString(1, usuario.getPassword());
			plantillaSQL.setString(2, usuario.getEmail());
			plantillaSQL.setString(3, usuario.getId_usuario());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Usuario> list() {
		Vector<Usuario> lista = new Vector();
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM Usuarios");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Usuario aux = new Usuario();
				aux.setId_usuario(resultado.getString("ID_USUARIO"));
				aux.setPassword(resultado.getString("password"));
				aux.setEmail(resultado.getString("email"));
				lista.add(aux);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	@Override
	public void delete(String id_usuario) {
		try {
			plantillaSQL = con.prepareStatement("DELETE FROM USUARIOS WHERE id_usuario=?");
			plantillaSQL.setString(1, id_usuario);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Usuario> lista_productos(String descripcionProducto) {
		Vector<Usuario> lista = new Vector();
			try {
				plantillaSQL = con.prepareStatement("SELECT u.id_usuario\r\n" + 
						"FROM producto  p\r\n" + 
						"INNER JOIN pos_facturas pf ON  pf.id_producto = p.id_producto\r\n" + 
						"INNER JOIN cab_facturas cf ON  pf.id_factura = cf.id_factura\r\n" + 
						"INNER JOIN usuarios u ON  cf.id_usuario = u.id_usuario\r\n" + 
						"where p.descripcion = ? ;");
				plantillaSQL.setString(1,descripcionProducto);
				resultado = plantillaSQL.executeQuery();
				while (resultado.next()) {
					Usuario aux = new Usuario();
					aux.setId_usuario(resultado.getString("u.id_usuario"));
			
					lista.add(aux);
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			return lista;
		}

	@Override
	public Vector<Usuario> lista_por_categoria(String descripcionCategoria) {
		Vector<Usuario> lista = new Vector();
		try {
			plantillaSQL = con.prepareStatement("SELECT distinct u.id_usuario\r\n" + 
					"FROM producto p\r\n" + 
					"INNER JOIN categorias c ON  c.idcategorias = p.idcategorias\r\n" + 
					"INNER JOIN pos_facturas pf ON p.id_producto = pf.id_producto\r\n" + 
					"INNER JOIN cab_facturas cf ON pf.id_factura = cf.id_factura\r\n" + 
					"INNER JOIN usuarios u ON cf.id_usuario = u.id_usuario\r\n" + 
					"where c.descripcion = ? ;");
			plantillaSQL.setString(1,descripcionCategoria);
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Usuario aux = new Usuario();
				aux.setId_usuario(resultado.getString("u.id_usuario"));
		
				lista.add(aux);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}
}
	

