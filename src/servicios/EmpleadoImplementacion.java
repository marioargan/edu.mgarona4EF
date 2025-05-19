package servicios;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import controladores.Inicio;
import dto.Dto;

public class EmpleadoImplementacion implements EmpleadoInterfaz {
	
	/*
	 * Metodo encargado de crear nuevos clientes y añadirlos tanto al clientes.txt como a la lista
	 */
	public void altaCliente() {
	    Path ruta = Paths.get(Inicio.ruta);
	    try {
	        System.out.println("Has escogido la opcion alta cliente");
	        System.out.println("Introduzca los datos del cliente");

	        System.out.print("Nombre del cliente: ");
	        String nombre = Inicio.sc.next();
	        Inicio.sc.nextLine();

	        System.out.print("Apellidos del cliente: ");
	        String apellidos = Inicio.sc.nextLine();

	        System.out.print("Contraseña del cliente: ");
	        String contraseña = Inicio.sc.nextLine();

	        System.out.print("Email del cliente: ");
	        String email = Inicio.sc.nextLine();

	        Dto nuevoClienteDto = new Dto(nombre, apellidos, contraseña, email);

	        Inicio.clientes.add(nuevoClienteDto);
	        String contenido = nombre + ";" + apellidos + ";" + contraseña + ";" + email + "\n";

	      
	        if (Files.size(ruta) > 0) {
	            Files.write(ruta, contenido.getBytes(), StandardOpenOption.APPEND);
	        } else {
	            Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8));
	        }

	    } catch (IOException e) {
	        registroLog("ERROR altaCliente IOException" + e.toString());
	    } catch (IllegalArgumentException e) {
	        registroLog("ERROR altaCliente IllegalArgument" + e.toString());
	    } catch (Exception e) {
	        registroLog("ERROR altaCliente General" + e.toString());
	    }
	}

	/*
	 * Mentodo encargado de mostrar todos los usuario que se encuentran en la lista
	 */
	@Override
    public void filtrar() {
        for (Dto cliente : Inicio.clientes) {
            System.out.println(cliente.toString());
        }
    }
	/*
	 * Metodo encargado de eliminar a los clientes
	 */
	@Override
	public void bajaCliente() {
        System.out.print("Introduzca el nombre del cliente a dar de baja: ");
        String nombre = Inicio.sc.next();
        Inicio.sc.nextLine(); 
        System.out.print("Introduzca los apellidos del cliente a dar de baja: ");
        String apellidos = Inicio.sc.nextLine();
        System.out.print("Introduzca el email del cliente a dar de baja: ");
        String email = Inicio.sc.nextLine();

        
        for (int i = 0; i < Inicio.clientes.size(); i++) {
            Dto cliente = Inicio.clientes.get(i);
            if (cliente.getNombre().equalsIgnoreCase(nombre)&& cliente.getApellidos().equalsIgnoreCase(apellidos)&& cliente.getEmail().equalsIgnoreCase(email)) {
                Inicio.clientes.remove(i);
                registroLog("bajaCliente Cliente eliminado: " + nombre + " " + apellidos + ", " + email);
                break;
            }
        }
    }
	
	/*
	 * metodo encargado de cargar en la lista los cliente que se encuentran en el archivo clientes.txt
	 */
	@Override
    public boolean cargarClientes() {
        boolean estaLeido = false;
        Path ruta = Paths.get(Inicio.ruta);

        try {
            List<String> lineas = Files.readAllLines(ruta);
            int i = 0;

            for (String linea : lineas) {
                if (i == 0) {
                    i = 1;
                    continue;
                }

                String[] campos = linea.split(";");
                Dto cliente = new Dto();
                cliente.setNombre(campos[0]);
                cliente.setApellidos(campos[1]);
                cliente.setContraseña(campos[2]);
                cliente.setEmail(campos[3]);

                Inicio.clientes.add(cliente);
            }

            estaLeido = true;
        } catch (IOException e) {
            registroLog("ERROR cargarClientes IOException" + e.toString());
            estaLeido = false;
        } catch (Exception e) {
            registroLog("ERROR cargarClientes General" + e.toString());
            estaLeido = false;
        }

        return estaLeido;
    }
	/*
	 * Metodo encargado de guardar en un archivoLog.txt los errores que van sucediendo durante el funcionamiento de la aplicacion
	 */
	public static void registroLog(String mensaje){
		
		Path ruta = Paths.get(Inicio.rutaLog);
			
			int numeroLineas;
			try {
				numeroLineas = Files.readAllLines(ruta).size();
				if(numeroLineas > 0) {
					Files.write(ruta, mensaje.getBytes(), StandardOpenOption.APPEND);
				}else {
					Files.write(ruta, mensaje.getBytes());
				}	
			} catch (IOException e) {
				
			}
		
	}
}
