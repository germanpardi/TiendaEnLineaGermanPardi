package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Factura;
import beans.Factura;
import interfaces.ICab_facturaDAO;


public class FacturaDAO implements ICab_facturaDAO{
	private Connection con;
	public Statement sentencia;
	public ResultSet resultado;
	public PreparedStatement plantillaSQL;

	public FacturaDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Factura findbyId(String id_factura) {
		Factura aux = null;
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM CAB_FACTURAS WHERE ID_FACTURA = ?");
			plantillaSQL.setString(1,id_factura);
			resultado = plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux = new Factura();
				aux.setId_factura(resultado.getInt("id_factura"));
				aux.setid_usuario(resultado.getString("id_usuario"));
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return aux;
	}

	@Override
	public void add(Factura factura) {
		//int id_factura=0;
		try {
			plantillaSQL = con.prepareStatement("INSERT INTO CAB_FACTURAS VALUES (?,?)");
			
			plantillaSQL.setString(2, factura.getid_usuario());
			plantillaSQL.setInt(1, factura.getId_factura());
			
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
			System.out.println(plantillaSQL.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		//return id_factura;
	}

	@Override
	public void save(Factura factura) {
		try {
			plantillaSQL = con.prepareStatement("UPDATE Cab_facturas SET id_usuario=? "
					+ "WHERE ID_factura=?");
			
			plantillaSQL.setInt(2, factura.getId_factura());
			plantillaSQL.setString(1, factura.getid_usuario());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Vector<Factura> list() {
		Vector<Factura> lista = new Vector();
		try {
			plantillaSQL = con.prepareStatement("SELECT * FROM Cab_facturas");
			resultado = plantillaSQL.executeQuery();
			while (resultado.next()) {
				Factura aux = new Factura();
				aux.setId_factura(resultado.getInt("ID_factura"));
				aux.setid_usuario(resultado.getString("descripcion"));
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
			plantillaSQL = con.prepareStatement("DELETE FROM Cab_facturas WHERE id_factura=?");
			plantillaSQL.setString(1, id_factura);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public int findMax() {
		int id_factura=0;
		try {
			plantillaSQL = con.prepareStatement("SELECT MAX(id_factura) FROM Cab_facturas");
			resultado = plantillaSQL.executeQuery();
			if(resultado.next()) {
				id_factura = (resultado.getInt("MAX(id_factura)"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return id_factura;
		
		
	}

}
