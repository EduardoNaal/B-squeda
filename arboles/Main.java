/**
 *
 * @author Eduardo
 */
public class Main {

    public static void main(String[] args) {
        //creacion de todo los nodos
        NodoArbol<String>[] nodos = new NodoArbol[16];
                         //   0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15
        String[] datos = {"B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q"};
        
        for(int i = 0; i < datos.length; i++){
            nodos[i] = new NodoArbol<String>(datos[i]);
        }
        
        // crear un arbol generico con su raiz
        Arbol<String> arbolG = new Arbol<>("A", false);
        System.out.println("Arbol Generico");
        //agregamos los nodos crados al arbol generico
        //A
        arbolG.agregarNodoArbol(arbolG.obtenerRaiz(), nodos[0]); //B
        arbolG.agregarNodoArbol(arbolG.obtenerRaiz(), nodos[1]); //C
        arbolG.agregarNodoArbol(arbolG.obtenerRaiz(), nodos[2]); //D
        //B
        arbolG.agregarNodoArbol(nodos[0], nodos[3]); //E
        arbolG.agregarNodoArbol(nodos[0], nodos[4]); //F
        //D
        arbolG.agregarNodoArbol(nodos[2], nodos[5]); //G
        arbolG.agregarNodoArbol(nodos[2], nodos[6]); //H
        arbolG.agregarNodoArbol(nodos[2], nodos[7]); //I
        //F
        arbolG.agregarNodoArbol(nodos[4], nodos[8]); //J
        arbolG.agregarNodoArbol(nodos[4], nodos[9]); //K
        arbolG.agregarNodoArbol(nodos[4], nodos[10]); //L
        //G
        arbolG.agregarNodoArbol(nodos[5], nodos[11]); //M
        //I
        arbolG.agregarNodoArbol(nodos[7], nodos[12]); //N
        arbolG.agregarNodoArbol(nodos[7], nodos[13]); //O
        //M
        arbolG.agregarNodoArbol(nodos[11], nodos[14]); //P
        arbolG.agregarNodoArbol(nodos[11], nodos[15]); //Q
        
        // imprecion de los tipos de recorrido
        System.out.println("Arbol genrerico en Prefijo:");
        arbolG.imprimirArbol(Recorrido.PREFIJO);

        System.out.println("\nArbol generico en Infijo:");
        arbolG.imprimirArbol(Recorrido.INFIJO);

        System.out.println("\nArbol generico en Posfijo:");
        arbolG.imprimirArbol(Recorrido.POSFIJO);
        
        System.out.println("\nla altura del arbol es: "+arbolG.obtenerAltura(arbolG.obtenerRaiz()));
        arbolG.imprimirSubArbol(arbolG.obtenerRaiz());
        System.out.println("\nEsta vacio el arbol? "+arbolG.estaVacio(arbolG));
        
        
        
        
        
        //creamos un arbol binario con su raiz
        
        for(int i = 0; i < datos.length; i++){
            nodos[i] = new NodoArbol<String>(datos[i]);
        }
        
        Arbol<String> arbolB = new Arbol<>("A",true);
        
        System.out.println("\n\nArbol binario");
        
        //agregamos los nodos crados al arbol binario
        //A
        arbolB.agregarNodoArbol(arbolB.obtenerRaiz(), nodos[0]); //B
        //B
        arbolB.agregarNodoArbol(nodos[0], nodos[3]); //E
        arbolB.agregarNodoArbol(nodos[0], nodos[1]); //C
        //C
        arbolB.agregarNodoArbol(nodos[1], nodos[2]); //D
        //D
        arbolB.agregarNodoArbol(nodos[2], nodos[5]); //G
        //E
        arbolB.agregarNodoArbol(nodos[3], nodos[4]); //F
        //F
        arbolB.agregarNodoArbol(nodos[4], nodos[8]); //J
        //G
        arbolB.agregarNodoArbol(nodos[5], nodos[11]); //M
        arbolB.agregarNodoArbol(nodos[5], nodos[6]); //H
        //H
        arbolB.agregarNodoArbol(nodos[6], nodos[7]); //I
        //I
        arbolB.agregarNodoArbol(nodos[7], nodos[12]); //N
        //J
        arbolB.agregarNodoArbol(nodos[8], nodos[9]); //K
        //K
        arbolB.agregarNodoArbol(nodos[9], nodos[10]); //L
        //M
        arbolB.agregarNodoArbol(nodos[11], nodos[14]); //P
        //N
        arbolB.agregarNodoArbol(nodos[12], nodos[13]); //O
        //P
        arbolB.agregarNodoArbol(nodos[14], nodos[15]); //Q
        
        //imprecion de los tipos de recorrido
        System.out.println("Arbol binario en Prefijo:");
        arbolB.imprimirArbol(Recorrido.PREFIJO);

        System.out.println("\nArbol binario en Infijo:");
        arbolB.imprimirArbol(Recorrido.INFIJO);

        System.out.println("\nArbol binario en Posfijo:");
        arbolB.imprimirArbol(Recorrido.POSFIJO);
        
        System.out.println("\nla altura del arbol es: "+arbolB.obtenerAltura(arbolG.obtenerRaiz()));
        arbolG.imprimirSubArbol(arbolB.obtenerRaiz());
        System.out.println("\nEsta vacio el arbol? "+arbolB.estaVacio(arbolG));
        
        System.out.println("");
        System.err.println("\nNOTA: EL CODIGO QUE NOS DIO NO CUMPLE CON LA REGLA DE LA INFIJO Y POSFIJO, YA QUE UN NODO NO PUEDE TENER UN NODO DERECHA SI NO TIENE UN NODO IZQUIERDA Y ESO HACE QUE CAMBIE AL IMPRIMIR LOS RECORRIDOS");
        System.err.println("POR ESO ENTREGUE TARDE EL CODIGO YA QUE VEIA QUE NO CUMPLIA Y QUERIA CONSULTARLO CON MIS COMPANEROS Y CON USTED, PERDON POR LA ENTREGA, QUERIA ENTREGARLO BIEN :3");
        
    }
        
}
