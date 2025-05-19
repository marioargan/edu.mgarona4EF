package servicios;

import controladores.Inicio;
/*
 * Clase encargada de mostrar el menu
 */
public class MenuImplementacion implements MenuInterfaz {
	
	@Override
	public byte menuPrincipal() {
		
		System.out.println("0. Cerrar aplicacion");
		System.out.println("1. Empleado");
		System.out.println("2. Cliente");
		System.out.println("Selecciona una opcion: ");
		Inicio.opcionUsuario = Inicio.sc.nextByte();
		return Inicio.opcionUsuario;
	}
}
