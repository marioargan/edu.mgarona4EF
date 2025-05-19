package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Dto;
import servicios.EmpleadoImplementacion;
import servicios.EmpleadoInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.SubMenuImplementacion;
import servicios.SubMenuInterfaz;

public class Inicio {
    public static byte opcionUsuario;
    public static Scanner sc = new Scanner(System.in);
    public static boolean cerrarAplicacion = false;
    public static String ruta = "/home/mgarona/Documents/ExamenProgFinal/edu.mgarona4EF/Clientes.txt";
    public static String rutaLog = "/home/mgarona/Documents/ExamenProgFinal/edu.mgarona4EF/ArchivoLog.txt";
    public static List<Dto> clientes = new ArrayList<>();

    public static void main(String[] args) {
        MenuInterfaz menu = new MenuImplementacion();
        SubMenuInterfaz subMenu = new SubMenuImplementacion();
        EmpleadoInterfaz empleadoInterfaz = new EmpleadoImplementacion();

       
        boolean cargado = empleadoInterfaz.cargarClientes();
        if (cargado) {
            System.out.println("Clientes cargados:");
            
        } else {
            EmpleadoImplementacion.registroLog("Error al cargar los clientes)");
        }

        try {
            do {
                opcionUsuario = menu.menuPrincipal();
                switch (opcionUsuario) {
                    case 0:
                        subMenu.CerraMenu();
                        break;
                    case 1:
                        subMenu.empleado();
                        break;
                    case 2:
                        subMenu.cliente();
                        break;
                    default:
                        break;
                }
            } while (!cerrarAplicacion);

        } catch (IllegalArgumentException e) {
            System.err.println("Has introducido algun valor erroneo");
            EmpleadoImplementacion.registroLog("ERROR-main IllegalArgument" + e.toString());
        } catch (Exception e) {
            System.err.println("Ha ocurrido algun error");
            EmpleadoImplementacion.registroLog("ERROR-main General" + e.toString());
        }
    }
}