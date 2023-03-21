
package proyecto.programacion;


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

    // verificar si es un operador
    boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^") || token.equals("sqrt");
    }

    public void imprimirNotacionPolaca() {
        System.out.print("Notación Polaca o Preorden: ");
        imprimirNotacionPolaca(raiz);
        System.out.println();
    }

    private void imprimirNotacionPolaca(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            imprimirNotacionPolaca(nodo.izquierdo);
            imprimirNotacionPolaca(nodo.derecho);
        }
    }

    public void imprimirInorder() {
        System.out.print("Inorder: ");
        imprimirInorder(raiz);
        System.out.println();
    }

    private void imprimirInorder(Nodo nodo) {
        if (nodo != null) {
            imprimirInorder(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            imprimirInorder(nodo.derecho);
        }
    }

    public void imprimirPostorden() {
        System.out.print("Notación Postorden: ");
        imprimirPostorden(this.raiz);
        System.out.println();
    }

    private void imprimirPostorden(Nodo nodo) {
        if (nodo != null) {
            return;
        } else {
            this.imprimirPostorden(nodo.izquierdo);
            this.imprimirPostorden(nodo.derecho);
            System.out.print(nodo.valor + " ");

        }

    }
