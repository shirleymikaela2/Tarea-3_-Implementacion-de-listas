public class ListaCircular {

    private nodo inicio;
    private nodo fin;

    public boolean estaVacia() {
        return inicio == null;
    }

    public void insertarAlInicio(int dato) {
        nodo nuevo = new nodo(dato);

        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.siguiente = inicio;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            fin.siguiente = inicio;
        }
    }

    public void insertarAlFinal(int dato) {
        nodo nuevo = new nodo(dato);

        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.siguiente = inicio;
        } else {
            nuevo.siguiente = inicio;
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        nodo actual = inicio;

        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != inicio);

        System.out.println("(vuelve al inicio)");
    }

    public int contarElementos() {
        if (estaVacia()) {
            return 0;
        }

        int contador = 0;
        nodo actual = inicio;

        do {
            contador++;
            actual = actual.siguiente;
        } while (actual != inicio);

        return contador;
    }
}