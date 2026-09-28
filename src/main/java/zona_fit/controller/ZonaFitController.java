package zona_fit.controller;


import zona_fit.data.ClienteDAO;
import zona_fit.domain.Cliente;

import java.util.List;
import java.util.Scanner;


public class ZonaFitController {

    private static final ClienteDAO clienteDAO = new ClienteDAO();

    public static void app(){
        Scanner sc = new Scanner(System.in);
        int op = 2;
        while(op != 6){
            showMenuCliente();
            System.out.print("Ingrese una opción: ");
            op = sc.nextInt();
            switch (op){
                case 1:
                    System.out.println("Clientes registrados:");
                    List<Cliente> clientes = listarClientes();
                    showClients(clientes);
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.print("Ingrese el ID del cliente a buscar: ");
                    int id = sc.nextInt();
                    buscarClientePorId(new Cliente(id));
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese el apellido del cliente: ");
                    String apellido = sc.next();
                    System.out.print("Ingrese el tipo de membresía del cliente: ");
                    int membresia = sc.nextInt();
                    agregarCliente(new Cliente(nombre, apellido, membresia));
                    break;
                case 4:
                    System.out.print("Ingrese el ID del cliente a actualizar: ");
                    id = sc.nextInt();
                    System.out.print("Ingrese el nuevo nombre del cliente: ");
                    nombre = sc.next();
                    System.out.print("Ingrese el nuevo apellido del cliente: ");
                    apellido = sc.next();
                    System.out.print("Ingrese el nuevo tipo de membresía del cliente: ");
                    membresia = sc.nextInt();
                    modificarCliente(new Cliente(id, nombre, apellido, membresia));
                    break;
                case 5:
                    System.out.print("Ingrese el id del usuario que desea eliminar: ");
                    id = sc.nextInt();
                    eliminarCliente(new Cliente(id));
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }


    }

    public static List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }

    public static void showClients(List<Cliente> cliente){
        cliente.forEach(System.out::println);
    }

    public static void buscarClientePorId(Cliente cliente) {
        if (!clienteDAO.buscarClientePorId(cliente)) {
            System.out.println("Cliente no encontrado.");
        }else{
            System.out.println("Cliente encontrado: ");
        }
    }

    public static void showMenuCliente() {
        System.out.println("\n--- Menú de Clientes ---");
        System.out.println("1. Listar clientes");
        System.out.println("2. Buscar cliente por ID");
        System.out.println("3. Agregar cliente");
        System.out.println("4. Actualizar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("6. Salir");
    }

    public static void agregarCliente(Cliente cliente) {
        boolean agregado = clienteDAO.agregarCliente(cliente);
        if (agregado) {
            System.out.println("Cliente agregado exitosamente.");
        } else {
            System.out.println("Error al agregar el cliente.");
        }
    }

    public static void modificarCliente(Cliente cliente) {
        boolean modificado = clienteDAO.modificarCliente(cliente);
        if (modificado) {
            System.out.println("Cliente modificado exitosamente.");
        } else {
            System.out.println("Id no existente");
        }
    }

    public static void eliminarCliente(Cliente cliente){
        boolean eliminado = clienteDAO.eliminarCliente(cliente);
        if (eliminado){
            System.out.println("Cliente eliminado exitosamente");
        }else{
            System.out.println("Id no existente");
        }
    }
}
