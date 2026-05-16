package principal;

import dao.UsuarioDAO;
import modelo.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UsuarioDAO dao = new UsuarioDAO();

        int opcion;

        do {

            System.out.println("\n=== CRUD USUARIOS JDBC ===");
            System.out.println("1. Insertar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre usuario: ");
                    String username = sc.nextLine();

                    System.out.print("Contraseña: ");
                    String password = sc.nextLine();

                    Usuario nuevo =
                            new Usuario(0, username, password);

                    dao.insertarUsuario(nuevo);

                    break;

                case 2:

                    dao.listarUsuarios();

                    break;

                case 3:

                    System.out.print("ID usuario: ");
                    int idActualizar = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Nuevo usuario: ");
                    String nuevoUsuario = sc.nextLine();

                    System.out.print("Nueva contraseña: ");
                    String nuevaPassword = sc.nextLine();

                    Usuario actualizar =
                            new Usuario(
                                    idActualizar,
                                    nuevoUsuario,
                                    nuevaPassword
                            );

                    dao.actualizarUsuario(actualizar);

                    break;

                case 4:

                    System.out.print("ID usuario a eliminar: ");

                    int idEliminar = sc.nextInt();

                    dao.eliminarUsuario(idEliminar);

                    break;

                case 5:

                    System.out.println("Saliendo...");

                    break;

                default:

                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);
    }
}