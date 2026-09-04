package Ejercicio2_InsercionEliminacion;

import java.util.Scanner;

public class MainControlado {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ListaCircularControlada lista = new ListaCircularControlada();

        int opcion;

        do {
            System.out.println("\n=== INSERCIÓN Y ELIMINACIÓN CONTROLADA ===");
            System.out.println("1. Insertar en una posición");
            System.out.println("2. Eliminar por posición");
            System.out.println("3. Eliminar por valor");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\nLista antes de insertar:");
                    lista.mostrar();

                    System.out.print("Ingrese el elemento: ");
                    int dato = teclado.nextInt();

                    System.out.print("Ingrese la posición: ");
                    int posicionInsertar = teclado.nextInt();

                    if (lista.insertarEnPosicion(dato, posicionInsertar)) {
                        System.out.println("Elemento insertado correctamente.");
                    } else {
                        System.out.println("La posición ingresada no es válida.");
                    }

                    System.out.println("Lista después de insertar:");
                    lista.mostrar();
                    break;

                case 2:
                    System.out.println("\nLista antes de eliminar:");
                    lista.mostrar();

                    System.out.print("Ingrese la posición que desea eliminar: ");
                    int posicionEliminar = teclado.nextInt();

                    if (lista.eliminarPorPosicion(posicionEliminar)) {
                        System.out.println("Elemento eliminado correctamente.");
                    } else {
                        System.out.println("La posición ingresada no existe.");
                    }

                    System.out.println("Lista después de eliminar:");
                    lista.mostrar();
                    break;

                case 3:
                    System.out.println("\nLista antes de eliminar:");
                    lista.mostrar();

                    System.out.print("Ingrese el valor que desea eliminar: ");
                    int valor = teclado.nextInt();

                    if (lista.eliminarPorValor(valor)) {
                        System.out.println("Valor eliminado correctamente.");
                    } else {
                        System.out.println("El valor no se encuentra en la lista.");
                    }

                    System.out.println("Lista después de eliminar:");
                    lista.mostrar();
                    break;

                case 4:
                    System.out.println("\nLista actual:");
                    lista.mostrar();
                    System.out.println(
                        "Número de elementos: " + lista.contarElementos()
                    );
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}