package servicios;

import controladores.Inicio;
import dto.Dto;

public class ClienteImplementacion implements ClienteInterfaz {
	
	public void inicioSesionCliente() {
		System.out.println("Inicio de sesion");
		System.out.println("Introduzca el email: ");
		String email = Inicio.sc.next();
		System.out.println("Introduzca la contraseña");
		String contraseña = Inicio.sc.next();
		
		for (Dto cliente : Inicio.clientes) {
			
			if (email.equals(cliente.getEmail())&&contraseña.equals(cliente.getContraseña())) {
				System.out.println("Se ha iniciado correctamente");
			}else {
				System.out.println("El email o la contraseña son incorrectos");
			}
		}
	}
}
