package Ejercicio4_Josephus;

public class Josephus {

    static class NodoPersona {
        int numero;
        NodoPersona siguiente;

        public NodoPersona(int numero) {
            this.numero = numero;
            this.siguiente = null;
        }
    }

    public static NodoPersona crearCirculo(int cantidad) {
        NodoPersona inicio = null;
        NodoPersona fin = null;

        for (int i = 1; i <= cantidad; i++) {
            NodoPersona nuevo = new NodoPersona(i);

            if (inicio == null) {
                inicio = nuevo;
                fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
        }

        fin.siguiente = inicio;
        return inicio;
    }

    public static void mostrarCirculo(NodoPersona inicio) {
        NodoPersona actual = inicio;

        System.out.print("Personas restantes: ");

        do {
            System.out.print(actual.numero);

            actual = actual.siguiente;

            if (actual != inicio) {
                System.out.print(" -> ");
            }

        } while (actual != inicio);

        System.out.println(" -> vuelve al inicio");
    }

    public static void resolverJosephus(int n, int k) {
        NodoPersona inicio = crearCirculo(n);
        NodoPersona actual = inicio;
        NodoPersona anterior = inicio;

        while (anterior.siguiente != inicio) {
            anterior = anterior.siguiente;
        }

        StringBuilder ordenEliminacion = new StringBuilder();

        System.out.println("\n============================");
        System.out.println("Josephus con n = " + n + " y k = " + k);
        mostrarCirculo(inicio);

        while (actual.siguiente != actual) {

            for (int contador = 1; contador < k; contador++) {
                anterior = actual;
                actual = actual.siguiente;
            }

            if (ordenEliminacion.length() > 0) {
                ordenEliminacion.append(" -> ");
            }

            ordenEliminacion.append(actual.numero);

            System.out.println("\nSe elimina a la persona: "
                    + actual.numero);

            anterior.siguiente = actual.siguiente;
            actual = actual.siguiente;
            inicio = actual;

            mostrarCirculo(inicio);
        }

        System.out.println("\nOrden de eliminación: "
                + ordenEliminacion);

        System.out.println("Superviviente final: persona "
                + actual.numero);
    }

    public static void main(String[] args) {

        resolverJosephus(5, 2);
        resolverJosephus(7, 3);
    }
}
