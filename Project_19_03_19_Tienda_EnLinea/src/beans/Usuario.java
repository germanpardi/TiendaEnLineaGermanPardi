package beans;


import excepciones.ExcepcionDomain;
import util.Validator;

public class Usuario {
	
	private String id_usuario;
	private String password;
	private String email;
	
	public Usuario() {
		super();
	}

	public Usuario(String id_usuario, String password, String email) {
		super();
		this.id_usuario = id_usuario;
		this.password = password;
		this.email = email;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		if(id_usuario.trim().equalsIgnoreCase("")) {
			throw new ExcepcionDomain("El nombre debe estar relleno.");
		}
		else {
		this.id_usuario= id_usuario;
		}
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password.trim().equalsIgnoreCase("")) {
			throw new ExcepcionDomain("Password debe estar relleno.");
		}
		else {
		this.password= password;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(Validator.validarMail(email)) {
			this.email = email;
		}
		else {
			throw new ExcepcionDomain("Email erroneo");

		}
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", password=" + password + ", email=" + email + "]";
	}
	
	

}
