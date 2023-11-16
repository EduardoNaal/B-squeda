/**
 * Clase que representa un nodo en un árbol genérico
 *
 * @param <T> Tipo de datos del nodo que es generica
 * @author Eduardo
 */
public class NodoArbol<T> {

    private T dato;                                 //el dato que tendra el nodo
    private boolean esBinario = false;              //si el nodo es binario
    private NodoArbol<T> primerHijo;                //el primer hijo del nodo (izquierda)
    private NodoArbol<T> siguienteHermano;          //el hermano del hijo o en cuyo caso del primer hijo (derecha)

    /**
     * Constructor de la clase NodoArbol
     *
     * @param dato datos que guardara el nodo
     */
    public NodoArbol(T dato) {
        this.dato = dato;
        primerHijo = null;
        siguienteHermano = null;
    }

    /**
     * se agraga un nodo hijo al nodo actual
     *
     * @param hijo el nodo hijo que se agregara
     */
    public void agregarHijo(NodoArbol<T> hijo) {
        if (primerHijo == null) {           //si no tiene hijo el nodo
            primerHijo = hijo;
        } else {
            NodoArbol<T> hermano = this.primerHijo;

            if (esBinario) {            //si es binario
                if (hermano.siguienteHermano != null) {
                    System.err.println("El nodo " + this.getDato() + " ya tiene un hijo, no se debe agregar " + hijo.getDato());
                } else {
                    hermano.siguienteHermano = hijo;
                }
            } else {                    //caso contrario
                while (hermano.siguienteHermano != null) {
                    hermano = hermano.siguienteHermano;
                }
                hermano.siguienteHermano = hijo;
            }
        }
    }

    /**
     * obtiener el primer hijo del nodo
     *
     * @return Primer hijo del nodo.
     */
    public NodoArbol<T> obtenerPrimerHijo() {
        return primerHijo;
    }

    /**
     * obtiener el siguiente hermano del nodo
     *
     * @return devuelve el siguiente hermano del nodo
     */
    public NodoArbol<T> obtenerSiguienteHermano() {
        return siguienteHermano;
    }

    /**
     * obtiener el dato guardado del nodo
     *
     * @return devuelve el dato del nodo guardado
     */
    public T getDato() {
        return dato;
    }

    /**
     * saber si el nodo es parte de un arbol binario
     *
     * @return devuelve: true si el nodo es parte de un arbol binario, false en
     * caso contrario
     */
    public boolean esBinario() {
        return esBinario;
    }

    /**
     * indicar si pertenece a un arbol binario
     *
     * @param esBinario devuelve: true si el nodo es parte de un arbol binario,
     * false en caso contrario
     */
    public void setEsBinario(boolean esBinario) {
        this.esBinario = esBinario;
    }

    /**
     * imprimir en orden prefijo los nodos
     */
    public void imprimirEnPrefijo() {
        System.out.print(dato + "\t");
        NodoArbol<T> hijo = primerHijo;

        while (hijo != null) {
            hijo.imprimirEnPrefijo();
            hijo = hijo.siguienteHermano;
        }
    }

    /**
     * imprimir en orden infijo los nodos
     */
    public void imprimirEnInfijo() {
        NodoArbol<T> hijo = primerHijo;

        if (hijo != null) {
            hijo.imprimirEnInfijo();
        }

        System.out.print(dato + "\t");
        while (hijo != null) {
            hijo = hijo.siguienteHermano;
            if (hijo != null) {
                hijo.imprimirEnInfijo();
            }
        }
    }

    /**
     * imprimir en orden posfijo los nodos
     */
    public void imprimirEnPosfijo() {
        NodoArbol<T> hijo = primerHijo;

        while (hijo != null) {
            hijo.imprimirEnPosfijo();
            hijo = hijo.siguienteHermano;
        }

        System.out.print(dato + "\t");
    }
}
