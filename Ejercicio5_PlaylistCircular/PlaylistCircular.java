package Ejercicio5_PlaylistCircular;

import java.util.Scanner;

public class PlaylistCircular {

    static class NodoCancion {
        String nombre;
        NodoCancion siguiente;

        public NodoCancion(String nombre) {
            this.nombre = nombre;
            this.siguiente = null;
        }
    }

    static NodoCancion inicio = null;
    static NodoCancion fin = null;
    static NodoCancion siguienteAReproducir = null;

    public static void agregarAlInicio(String nombre) {
        NodoCancion nueva = new NodoCancion(nombre);

        if (inicio == null) {
            inicio = nueva;
            fin = nueva;
            fin.siguiente = inicio;
            siguienteAReproducir = inicio;
        } else {
            nueva.siguiente = inicio;
            inicio = nueva;
            fin.siguiente = inicio;
        }

        System.out.println("Canción agregada al inicio.");
    }

    public static void agregarAlFinal(String nombre) {
        NodoCancion nueva = new NodoCancion(nombre);

        if (inicio == null) {
            inicio = nueva;
            fin = nueva;
            fin.siguiente = inicio;
            siguienteAReproducir = inicio;
        } else {
            nueva.siguiente = inicio;
            fin.siguiente = nueva;
            fin = nueva;
        }

        System.out.println("Canción agregada al final.");
    }

    public static void mostrarPlaylist() {
        if (inicio == null) {
            System.out.println("La playlist está vacía.");
            return;
        }

        NodoCancion actual = inicio;

        System.out.print("Playlist: ");

        do {
            System.out.print(actual.nombre);
            actual = actual.siguiente;

            if (actual != inicio) {
                System.out.print(" -> ");
            }

        } while (actual != inicio);

        System.out.println(" -> vuelve a la primera canción");
    }

    public static void reproducirSiguiente() {
        if (siguienteAReproducir == null) {
            System.out.println("No existen canciones para reproducir.");
            return;
        }

        System.out.println(
            "Reproduciendo: " + siguienteAReproducir.nombre
        );

        siguienteAReproducir = siguienteAReproducir.siguiente;
    }

    public static boolean eliminarCancion(String nombre) {
        if (inicio == null) {
            return false;
        }

        NodoCancion actual = inicio;
        NodoCancion anterior = fin;

        do {
            if (actual.nombre.equalsIgnoreCase(nombre)) {

                if (inicio == fin) {
                    inicio = null;
                    fin = null;
                    siguienteAReproducir = null;

                } else {
                    anterior.siguiente = actual.siguiente;

                    if (actual == inicio) {
                        inicio = actual.siguiente;
                    }

                    if (actual == fin) {
                        fin = anterior;
                    }

                    if (actual == siguienteAReproducir) {
                        siguienteAReproducir = actual.siguiente;
                    }

                    fin.siguiente = inicio;
                }

                return true;
            }

            anterior = actual;
            actual = actual.siguiente;

        } while (actual != inicio);

        return false;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== PLAYLIST CIRCULAR ===");
            System.out.println("1. Agregar canción al inicio");
            System.out.println("2. Agregar canción al final");
            System.out.println("3. Mostrar playlist");
            System.out.println("4. Reproducir siguiente canción");
            System.out.println("5. Eliminar canción por nombre");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Nombre de la canción: ");
                    String cancionInicio = teclado.nextLine();
                    agregarAlInicio(cancionInicio);
                    break;

                case 2:
                    System.out.print("Nombre de la canción: ");
                    String cancionFinal = teclado.nextLine();
                    agregarAlFinal(cancionFinal);
                    break;

                case 3:
                    mostrarPlaylist();
                    break;

                case 4:
                    reproducirSiguiente();
                    break;

                case 5:
                    System.out.print(
                        "Nombre de la canción que desea eliminar: "
                    );
                    String nombreEliminar = teclado.nextLine();

                    if (eliminarCancion(nombreEliminar)) {
                        System.out.println(
                            "Canción eliminada correctamente."
                        );
                    } else {
                        System.out.println(
                            "La canción no se encuentra en la playlist."
                        );
                    }
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
