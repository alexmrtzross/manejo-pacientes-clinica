import java.util.Scanner;

public class ej1 {

    static Scanner sc = new Scanner(System.in);

    // declaro un arreglo de 10 clientes de la clase cliente
    static cliente[] clientes50 = new cliente[10];
    static cliente[] clientesmen = new cliente[10];

    public static void main(String[] args) {

        int opcion = 0;

        do {

            /*
             * Hasta que se decida atender se debe mostrar el mensaje Atendiendo a > nombre
             * del cliente
             */
            System.out.println("\n");
            if (opcion != 2) {
                System.out.println("Atendiendo a > ");
            }

            /*
             * Se muestra los clientes que hay en la cola de clientesmen, si esta vacio se
             * muestra el mensaje vacio
             */
            System.out.print("\n" + "Cola de clientes menores a 50 -> ");
            for (int i = 0; i < clientesmen.length; i++) {
                if (clientesmen[i] != null) {
                    System.out.print("N: " + clientesmen[i].getNombre() + " E: " + clientesmen[i].getEdad() + " | ");
                }
            }
            if (clientesmen[0] == null) {
                System.out.println("Vacio" + "\n");
            }

            /*
             * Se muestra los clientes que hay en la cola de clientes50, si esta vacio se
             * muestra el mensaje vacio
             */
            System.out.print("\n" + "Cola de clientes mayores a 50 -> ");
            for (int i = 0; i < clientes50.length; i++) {
                if (clientes50[i] != null) {

                    System.out.print("N: " + clientes50[i].getNombre() + " E: " + clientes50[i].getEdad() + " | ");

                }
            }
            if (clientes50[0] == null) {

                System.out.print("Vacio" + "\n");

            }

            System.out.println("\n");
            System.out.println("----Menu principal----");
            System.out.println("1. Ingresar nuevo cliente");
            System.out.println("2. Atender a un cliente");
            System.out.println("3. Salir");
            System.out.println("\n");
            System.out.print("Ingrese una opcion >> ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresarCliente();
                    break;
                case 2:
                    atenderCliente();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida, elije una opcion correcta");
            }

        } while (opcion != 3);

    }

    public static void ingresarCliente() {
        /*
         * pide los datos del cliente, los asigna y luego lo agrega al arreglo en una
         * posicion libre, si la edad del paciente es mayor a 50 se agrega en el arreglo
         * de pacientes de 50 o mas si la edad es menor a 50 se agrega en el arreglo de
         * pacientes menores de 50 si no hay espacio en ninguno de los arreglos, se
         * muestra un mensaje de error
         */

        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.next();
        System.out.print("Ingrese la edad del cliente: ");
        int edad = sc.nextInt();
        if (edad >= 50) {
            for (int i = 0; i < clientes50.length; i++) {
                if (clientes50[i] == null) {
                    clientes50[i] = new cliente(nombre, edad);
                    break;
                }
            }
        } else {
            for (int i = 0; i < clientesmen.length; i++) {
                if (clientesmen[i] == null) {
                    clientesmen[i] = new cliente(nombre, edad);
                    break;
                }
            }
        }
        System.out.println("\n");
        System.out.println("Cliente " + nombre + " " + " ingresado con exito");
        System.out.println("_______________________________________________________");

    }

    public static void atenderCliente() {
        /*
         * recorre el primero arreglo de mayores de 50 y atiende al primero, Si el
         * primero arreglo esta vacio recorre el segundo y atiende el primero, si ya no
         * hay mas en ambos arreglos muestra mensaje
         */
        if (clientes50[0] != null) {
            System.out.println("Atendiendo a > " + clientes50[0].getNombre());
            clientes50[0] = null;
            for (int i = 0; i < clientes50.length - 1; i++) {
                clientes50[i] = clientes50[i + 1];
            }
        } else if (clientesmen[0] != null) {
            System.out.println("Atendiendo a > " + clientesmen[0].getNombre());
            clientesmen[0] = null;
            for (int i = 0; i < clientesmen.length - 1; i++) {
                clientesmen[i] = clientesmen[i + 1];
            }
        } else {
            System.out.println("\n" + "No hay clientes en espera");
        }

        /* Re ordena el arreglo */
        for (int i = 0; i < clientes50.length; i++) {
            if (clientes50[i] == null) {
                for (int j = i + 1; j < clientes50.length; j++) {
                    if (clientes50[j] != null) {
                        clientes50[i] = clientes50[j];
                        clientes50[j] = null;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < clientesmen.length; i++) {
            if (clientesmen[i] == null) {
                for (int j = i + 1; j < clientesmen.length; j++) {
                    if (clientesmen[j] != null) {
                        clientesmen[i] = clientesmen[j];
                        clientesmen[j] = null;
                        break;
                    }
                }
            }
        }
    }
}
