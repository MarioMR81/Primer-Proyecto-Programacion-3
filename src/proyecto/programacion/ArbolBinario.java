
package proyecto.programacion;

import java.util.Stack;


public class ArbolBinario {
    
        Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    void crearArbol(String expresion) {
        Stack<Nodo> pila = new Stack<Nodo>();
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            Nodo nodo = new Nodo(token);

            if (esOperador(token)) {
                nodo.derecho = pila.pop();
                nodo.izquierdo = pila.pop();
            } else if (token.equals(")")) {
                while (!pila.peek().valor.equals("(")) {
                    Nodo hijo = pila.pop();
                    hijo.derecho = nodo.izquierdo;
                    hijo.izquierdo = nodo.derecho;
                    nodo = hijo;
                }
                pila.pop();
            }
            pila.push(nodo);
        }
        raiz = pila.pop();
    }
    
}
