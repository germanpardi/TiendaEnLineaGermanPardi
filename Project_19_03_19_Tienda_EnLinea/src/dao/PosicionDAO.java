package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Posicion;

import interfaces.IPosicionDAO;

public class PosicionDAO implements IPosicionDAO {

	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;

	public  PosicionDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Posicion findbyId(String id_factura) {
		Posicion aux = null;
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM pos_facturas WHERE id_factura = ?");
			plantillaSQL.setString(1, id_factura);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux = new Posicion();
				aux.setId_factura(resultado.getInt("ID_factura"));
				aux.setPos_factura(resultado.getInt("pos_factura"));
				aux.setId_producto(resultado.getInt("ID_PRODUCTO"));
				aux.setCantidad(resultado.getInt("Cantidad"));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return aux;
	}

	@Override
	public void add(Posicion posicion) {
		try {
			plantillaSQL = con.prepareStatement("INSERT INTO pos_facturas VALUES (?, ?, ?, ?)");
			plantillaSQL.setInt(1, posicion.getId_factura());
			plantillaSQL.setInt(2, posicion.getPos_factura());
			plantillaSQL.setInt(3, posicion.getId_producto());
			plantillaSQL.setInt(4, posicion.getCantidad());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

	@Override
	public void save(Posicion posicion) {
		try {
			plantillaSQL = con
					.prepareStatement("UPDATE pos_facturas SET POS_FACTURA= ? ,ID_PRODUCTO = ? , CANTIDAD = ?,   " + "WHERE ID_FACTURA=?");
			plantillaSQL.setInt(1, posicion.getPos_factura());
			plantillaSQL.setInt(2, posicion.getId_producto());
			plantillaSQL.setDouble(3, posicion.getCantidad());
			plantillaSQL.setInt(5, posicion.getId_factura());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public Vector<Posicion> list() {
		Vector<Posicion> lista = new Vector();
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM posicion");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Posicion aux = new Posicion();
				aux.setId_factura(resultado.getInt("ID_Factura"));
				aux.setPos_factura(resultado.getInt("POS_FACTURA"));
				aux.setId_producto(resultado.getInt("ID_PRODUCTO"));
				aux.setCantidad(resultado.getInt("CANTIDAD"));
				lista.add(aux);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	@Override
	public void delete(String id_factura) {
		try {
			plantillaSQL = con.prepareStatement("DELETE FROM pos_facturas WHERE id_Factura=?");
			plantillaSQL.setString(1, id_factura);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
