package Ejercicio3_RoundRobin;

import java.util.Scanner;

public class RoundRobin {

    static final int QUANTUM = 2;

    static class NodoProceso {
        String nombre;
        int tiempoRestante;
        NodoProceso siguiente;

        public NodoProceso(String nombre, int tiempoRestante) {
            this.nombre = nombre;
            this.tiempoRestante = tiempoRestante;
            this.siguiente = null;
        }
    }

    static NodoProceso inicio = null;
    static NodoProceso fin = null;

    public static void agregarProceso(String nombre, int tiempoRestante) {
        NodoProceso nuevo = new NodoProceso(nombre, tiempoRestante);

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
            fin.siguiente = inicio;
        } else {
            nuevo.siguiente = inicio;
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public static void eliminarProcesoActual() {
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            inicio = inicio.siguiente;
            fin.siguiente = inicio;
        }
    }

    public static void mostrarLista() {
        if (inicio == null) {
            System.out.println("Estado de la lista: vacía");
            return;
        }

        NodoProceso actual = inicio;

        System.out.print("Estado de la lista: ");

        do {
            System.out.print(
                "[" + actual.nombre + ": "
                + actual.tiempoRestante + "]"
            );

            actual = actual.siguiente;

            if (actual != inicio) {
                System.out.print(" -> ");
            }

        } while (actual != inicio);

        System.out.println(" -> vuelve al inicio");
    }

    public static void simularRoundRobin() {
        int turno = 1;

        while (inicio != null) {
            NodoProceso procesoActual = inicio;

            int tiempoEjecutado = Math.min(
                QUANTUM,
                procesoActual.tiempoRestante
            );

            System.out.println("\nTurno " + turno);
            System.out.println(
                "Proceso ejecutado: " + procesoActual.nombre
            );
            System.out.println(
                "Tiempo ejecutado: " + tiempoEjecutado
            );

            procesoActual.tiempoRestante -= tiempoEjecutado;

            if (procesoActual.tiempoRestante == 0) {
                System.out.println(
                    "El proceso " + procesoActual.nombre
                    + " terminó y se elimina de la lista."
                );

                eliminarProcesoActual();

            } else {
                System.out.println(
                    "Tiempo restante de "
                    + procesoActual.nombre + ": "
                    + procesoActual.tiempoRestante
                );

                inicio = inicio.siguiente;
                fin = fin.siguiente;
            }

            mostrarLista();
            turno++;
        }

        System.out.println("\nTodos los procesos terminaron.");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("=== SIMULACIÓN ROUND-ROBIN ===");
        System.out.println("Quantum: " + QUANTUM);

        System.out.print("Ingrese el número de procesos: ");
        int cantidadProcesos = teclado.nextInt();
        teclado.nextLine();

        for (int i = 1; i <= cantidadProcesos; i++) {
            System.out.print(
                "\nNombre del proceso " + i + ": "
            );
            String nombre = teclado.nextLine();

            System.out.print("Tiempo requerido: ");
            int tiempo = teclado.nextInt();
            teclado.nextLine();

            agregarProceso(nombre, tiempo);
        }

        System.out.println("\nLista inicial:");
        mostrarLista();

        simularRoundRobin();

        teclado.close();
    }
}