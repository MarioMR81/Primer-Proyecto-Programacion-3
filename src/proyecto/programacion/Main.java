
package proyecto.programacion;

import java.util.*;
import javax.swing.JOptionPane;


public class Main {


    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
        boolean salir = false, salirMenu = false;

        do {

            String expresion = JOptionPane.showInputDialog("Ingrese la expresion matematica");
            if (validarExpresion(expresion)) {
                String expresionProcesada = procesar(expresion);
                // Creamos el árbol binario y lo construimos a partir de la expresión
                ArbolBinario arbol = new ArbolBinario();
                String polaca = convertirPolaca(expresionProcesada);// convierte la expresion introducida polaca o preorden
                arbol.crearArbol(polaca);// se crea el arbol a partir de la expresion
                System.out.println("-----------Arbol Grafico-----------");
                arbol.imprimirArbolVertical();
                System.out.println("------------------------------------");
                do {
                    // menu
                    System.out.println("MENU");
                    System.out.println("1. Imprimir notación polaca o prefija");
                    System.out.println("2. Imprimir notacion inorder");
                    System.out.println("3. Imprimir notación postfija");
                    int opcion = sc.nextInt();
                    sc.nextLine(); // Consumir la línea vacía después de leer la opción
                    switch (opcion) {
                        case 1:
                            arbol.imprimirNotacionPolaca();
                            break;
                        case 2:
                            arbol.imprimirInorder();
                            break;
                        case 3:
                            arbol.imprimirPostorden();
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                    System.out.println("Desea imprimir alguna otra notacion?");
                    System.out.println("1. si");
                    System.out.println("2. no");
                    int opcionMenu=sc.nextInt();
                    sc.nextLine();
                    if (opcionMenu!=1) {
                        salirMenu = true;
                    }
                } while (!salirMenu);
                // Recursividad
                double resultado = resolverExpresion(arbol.raiz);
                System.out.println("El resultado es: " + resultado);
            } else {
                System.out.println("La expresión no es válida");

            }
            System.out.println("Desea ingresar otra expresion?");
            System.out.println("1. si");
            System.out.println("2. no");
            int opcionMenu=sc.nextInt();
            sc.nextLine();
            if (opcionMenu!=1) {
                salir = true;
            }
        } while (!salir);
    }

