/**
 * Clase para crear un arbol
 *
 * @param <T> Tipo de datos del arbol que es generico
 * @author Eduardo
 */
public class Arbol<T> {

    private NodoArbol<T> raiz;              // la variable raiz es el nodo raiz del arbol

    private boolean esBinario = false;      // si el arbol es binario o general

    /**
     * Constructor de la clase Arbol
     *
     * @param dato dato que recibe la variable raiz del arbol
     * @param esBinario si el arbol es binario o no
     */
    public Arbol(T dato, boolean esBinario) {
        raiz = new NodoArbol<T>(dato);
        raiz.setEsBinario(esBinario);
        this.esBinario = esBinario;
    }

    /**
     * Obtiener la raiz del arbol
     *
     * @return devuelve la raiz
     */
    public NodoArbol<T> obtenerRaiz() {
        return raiz;
    }

    /**
     * comprobar si el arbol es binario
     *
     * @return devuelve: true si el arbol es binario, false cuando no lo es
     */
    public boolean esBinario() {
        return esBinario;
    }

    /**
     * Agrega un nodo al arbol
     *
     * @param nodoRaiz sera la raiz del subarbol del arbol
     * @param nodoAgregado el nuevo nodo que se le agrega al subarbol
     */
    public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) {
        if (esBinario) {
            nodoAgregado.setEsBinario(esBinario);
        }
        nodoRaiz.agregarHijo(nodoAgregado);
    }

    /**
     * saber si el arbol esta vacio
     *
     * @param arbol el arbol que deseabos saber su tamaño
     * @return devuelve: true si el arbol esta vacio, false en caso contrario
     */
    public boolean estaVacio(Arbol<T> arbol) {
        return arbol.obtenerRaiz() == null;
    }

    /*
     * obtener la altura del arbol
     *
     * @return devuelve la altura del arbol
     */

    /**
     * calcula la altura del sub-arbol a partir del nodo seleccionado
     *
     * @param nodoRaiz el nodo que ahora sera la raiz y se calculara la altura del sub-arbol
     * @return devuelve la altura del sub-arbol,  dicha altura del sub-arbol es la maxima entre las alturas izquierda y derecha +1
     */
    public int obtenerAltura(NodoArbol<T> nodoRaiz) {
        //si el nodo es nulo, la atura es -1 o 0, en caso contrario calculara la altura del sub-arbol del lado izquierdo como el derecho
        if (nodoRaiz == null) {
            return -1;
        } else {
            int alturaIzquierdo = obtenerAltura(nodoRaiz.obtenerPrimerHijo());
            int alturaDerecho = obtenerAltura(nodoRaiz.obtenerSiguienteHermano());
            
            return Math.max(alturaIzquierdo, alturaDerecho) + 1;
        }
    }

    /**
     * imprimir el sub-arbol a partir de un nodo recibido
     *
     * @param nodoArbol el nodo a partir del cual se imprimira el sub-arbol.
     */
    public void imprimirSubArbol(NodoArbol<T> nodoArbol) {
        imprimirSubArbolRecursivo(nodoArbol, 0);
    }

    /**
     * imprimir el sub-arbol
     *
     * @param nodoArbol  el nodo actual en el recorrido del sub-arbol
     * @param nivelArbol el nivel actual en el arbol (para la indentación).
     */
    private void imprimirSubArbolRecursivo(NodoArbol<T> nodoArbol, int nivelArbol) {
        if (nodoArbol != null) {
            System.out.print("["+nodoArbol.getDato()+", ");
            NodoArbol<T> hijo = nodoArbol.obtenerPrimerHijo();
            while (hijo != null) {
                imprimirSubArbolRecursivo(hijo, nivelArbol + 1);
                hijo = hijo.obtenerSiguienteHermano();
            }
        } else {
            System.out.println("El nodo proporcionado es nulo.");
        }
    }
    
    /**
     * imprimir el arbol dependiendo el tipo de recorrido seleccionado
     *
     * @param recorrido tipo de recorrido: Prefijo, Infijo, Posfijo
     */
    public void imprimirArbol(Recorrido recorrido) {
        switch (recorrido.ordinal()) {
            case 0:
                System.out.println("Prefijo: ");
                raiz.imprimirEnPrefijo();
                break;

            case 1:
                System.out.println("\nInfijo: ");
                raiz.imprimirEnInfijo();
                break;

            case 2:
                System.out.println("\nPosfijo: ");
                raiz.imprimirEnPosfijo();
                break;

            default:
                break;
        }
    }
}
