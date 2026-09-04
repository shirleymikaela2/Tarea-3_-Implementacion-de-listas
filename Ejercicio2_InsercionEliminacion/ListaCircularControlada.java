package Ejercicio2_InsercionEliminacion;

public class ListaCircularControlada {

    private NodoControlado inicio;
    private NodoControlado fin;
    private int cantidad;

    public boolean estaVacia() {
        return inicio == null;
    }

    public int contarElementos() {
        return cantidad;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacía.");
            return;
        }

        NodoControlado actual = inicio;

        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != inicio);

        System.out.println("(vuelve al inicio)");
    }

    public boolean insertarEnPosicion(int dato, int posicion) {
        if (posicion < 1 || posicion > cantidad + 1) {
            return false;
        }

        NodoControlado nuevo = new NodoControlado(dato);

        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.siguiente = inicio;

        } else if (posicion == 1) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            fin.siguiente = inicio;

        } else if (posicion == cantidad + 1) {
            nuevo.siguiente = inicio;
            fin.siguiente = nuevo;
            fin = nuevo;

        } else {
            NodoControlado actual = inicio;

            for (int i = 1; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }

            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }

        cantidad++;
        return true;
    }

    public boolean eliminarPorPosicion(int posicion) {
        if (posicion < 1 || posicion > cantidad) {
            return false;
        }

        if (cantidad == 1) {
            inicio = null;
            fin = null;

        } else if (posicion == 1) {
            inicio = inicio.siguiente;
            fin.siguiente = inicio;

        } else {
            NodoControlado anterior = inicio;

            for (int i = 1; i < posicion - 1; i++) {
                anterior = anterior.siguiente;
            }

            NodoControlado eliminado = anterior.siguiente;
            anterior.siguiente = eliminado.siguiente;

            if (eliminado == fin) {
                fin = anterior;
            }

            fin.siguiente = inicio;
        }

        cantidad--;
        return true;
    }

    public boolean eliminarPorValor(int valor) {
        if (estaVacia()) {
            return false;
        }

        NodoControlado actual = inicio;
        NodoControlado anterior = fin;

        do {
            if (actual.dato == valor) {

                if (cantidad == 1) {
                    inicio = null;
                    fin = null;

                } else {
                    anterior.siguiente = actual.siguiente;

                    if (actual == inicio) {
                        inicio = actual.siguiente;
                    }

                    if (actual == fin) {
                        fin = anterior;
                    }

                    fin.siguiente = inicio;
                }

                cantidad--;
                return true;
            }

            anterior = actual;
            actual = actual.siguiente;

        } while (actual != inicio);

        return false;
    }
}