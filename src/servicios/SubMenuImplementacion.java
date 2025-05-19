package servicios;

import controladores.Inicio;
/*
 * Clase encargada de mostrar el submenu y sus funcionalidades
 */
public class SubMenuImplementacion implements SubMenuInterfaz {
	
	@Override
	public void empleado() {
		EmpleadoInterfaz empleado= new EmpleadoImplementacion();
		System.out.println("1. Nuevo Cliente");
		System.out.println("2. Baja Cliente");
		System.out.println("3.Mostrar Clientes");
		System.out.println("4. Menu Principal");
		System.out.println("Selecciona una opcion: ");
		Inicio.opcionUsuario = Inicio.sc.nextByte();
		
		switch (Inicio.opcionUsuario){
		case 1: {
			empleado.altaCliente();
			break;
		}
		case 2: {
			empleado.bajaCliente();
			break;
		}
		case 3: {
			empleado.filtrar();
			break;
		}
		case 4: {
			break;
		}
		default:
			
		}
	}
	
	@Override
	public void cliente() {
		ClienteInterfaz cliente = new ClienteImplementacion();
		System.out.println("1. Iniciar Sesion");
		System.out.println("2. Menu Principal");
		System.out.println("Selecciona una opcion: ");
		Inicio.opcionUsuario = Inicio.sc.nextByte();
		
		switch (Inicio.opcionUsuario){
		case 1: {
			cliente.inicioSesionCliente();
			break;
		}
		case 2: {
			
			break;
		}
		
		default:
			break;
		}
	}
	
	@Override
	public void CerraMenu() {
		
		System.out.println("¿Deseas cerrar el Menu?");
		String respuestaUsuario = Inicio.sc.next().toLowerCase();
		if (respuestaUsuario.equals("si")) {
			Inicio.cerrarAplicacion=true;
		}
	}
}
