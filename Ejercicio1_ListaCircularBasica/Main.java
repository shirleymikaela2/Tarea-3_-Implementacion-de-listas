import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ListaCircular lista = new ListaCircular();
        int opcion;

        do {
            System.out.println("\n=== LISTA CIRCULAR ===");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Mostrar elementos");
            System.out.println("4. Verificar si la lista está vacía");
            System.out.println("5. Contar elementos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el elemento: ");
                    int datoInicio = teclado.nextInt();
                    lista.insertarAlInicio(datoInicio);
                    System.out.println("Elemento insertado al inicio.");
                    break;

                case 2:
                    System.out.print("Ingrese el elemento: ");
                    int datoFinal = teclado.nextInt();
                    lista.insertarAlFinal(datoFinal);
                    System.out.println("Elemento insertado al final.");
                    break;

                case 3:
                    System.out.println("Elementos de la lista:");
                    lista.mostrar();
                    break;

                case 4:
                    if (lista.estaVacia()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        System.out.println("La lista no está vacía.");
                    }
                    break;

                case 5:
                    System.out.println(
                        "Número de elementos: " + lista.contarElementos()
                    );
                    break;

                case 6:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 6);

        teclado.close();
    }
}