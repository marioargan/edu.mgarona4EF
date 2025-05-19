package dto;

public class Dto {
	int id;
	String nombre;
	String apellidos;
	String contraseña;
	String email;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "---------------------".concat("\n")
				.concat("Nombre Completo: ").concat(nombre).concat(" ").concat(apellidos).concat("\n")
				.concat("Contraseña: ").concat("******").concat("\n")
				.concat("Email: ").concat(email).concat("\n")
				.concat("-----------------------");
	}
	public Dto(String nombre, String apellidos, String contraseña, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contraseña = contraseña;
		this.email = email;
	}
	public Dto() {
		super();
	}
	
	
	
	
	
}
