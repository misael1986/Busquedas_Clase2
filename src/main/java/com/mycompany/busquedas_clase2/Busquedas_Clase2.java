/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.busquedas_clase2;

/**
 *
 * @author misael.perilla
 */
public class Busquedas_Clase2 {

    public static void main(String[] args) {

        int[] misNumeros = new int[20];

//        for (int i = 0; i < misNumeros.length; i++) {
//            misNumeros[i] = (int) (Math.random() * 100);
//        }
//
//        Imprimir(misNumeros);
//        System.out.println("Burbuja:");
//        Imprimir(Burbuja(misNumeros));
//        Imprimir(Seleccion(misNumeros));
//        Imprimir(Insercion(misNumeros));



        misNumeros[0] = 10;
        misNumeros[1] = 13;
        misNumeros[2] = 16;
        misNumeros[3] = 19;
        misNumeros[4] = 22;
        misNumeros[5] = 25;
        misNumeros[6] = 28;
        misNumeros[7] = 31;
        misNumeros[8] = 34;
        misNumeros[9] = 37;
        misNumeros[10] = 40;
        misNumeros[11] = 43;
        misNumeros[12] = 46;
        misNumeros[13] = 49;
        misNumeros[14] = 52;
        misNumeros[15] = 55;
        misNumeros[16] = 58;
        misNumeros[17] = 61;
        misNumeros[18] = 64;
        misNumeros[19] = 67;

        System.out.println("Busqueda Lineal\n");

        int resultadoLineal = busquedaBinaria(misNumeros, 37);
        System.out.println("El número 37 está en la posición: " + resultadoLineal);

        resultadoLineal = busquedaBinaria(misNumeros, 70);
        System.out.println("El número 70 está en la posición: " + resultadoLineal);

        System.out.println("Busqueda Binaria\n");

        int resultadoBinario = busquedaBinaria(misNumeros, 37);
        System.out.println("El número 37 está en la posición: " + resultadoBinario);

        resultadoBinario = busquedaBinaria(misNumeros, 70);
        System.out.println("El número 70 está en la posición: " + resultadoBinario);
    }

    //----------------------------
    //----------------------------
    public static int[] Burbuja(int[] A) {
        int i, j, aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] < A[j]) {  //se comparan 2 valores y su el segundo es menor
                    aux = A[j + 1];     //se asigna el de la segunda posicion a variable auxiliar
                    A[j + 1] = A[j];    //luego se asigna el primer valor al segundo
                    A[j] = aux;         //se reasigna el segundo valor al primero para ordenarlo
                }                       // intercambio usando una variable temporal o auxiliar
            }
        }
        return A;
    }

    //----------------------------
    //----------------------------      
    public static int[] Seleccion(int A[]) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < A.length - 1; i++) {      // tomamos como menor el primero
            menor = A[i];                       // de los elementos que quedan por ordenar                    
            pos = i;                            // y guardamos su posición
            for (j = i + 1; j < A.length; j++) { // buscamos en el resto
                if (A[j] < menor) {           // del array algún elemento
                    menor = A[j];             // menor que el actual
                    pos = j;
                }
            }
            if (pos != i) {                      // si hay alguno menor se intercambia                         
                tmp = A[i];
                A[i] = A[pos];
                A[pos] = tmp;
            }
        }
        return A;
    }

    //----------------------------
    //----------------------------  
    public static int[] Insercion(int A[]) {
        int p, j;
        int aux;
        for (p = 1; p < A.length; p++) { // desde el segundo elemento hasta
            aux = A[p];           // el final, guardamos el elemento y
            j = p - 1;            // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux < A[j])) { // mientras queden posiciones y el                                
                // valor de aux sea menor que los
                A[j + 1] = A[j];   // de la izquierda, se desplaza a
                j--;               // la derecha
            }
            A[j + 1] = aux;       // colocamos aux en su sitio
        }
        return A;
    }

    //----------------------------
    //----------------------------
    public static int busquedaBinaria(int[] items, int numeroBuscado) {
        int result = -1;
        int limiteInferior = 0;
        int limiteSuperior = items.length - 1;
        int indice;

        while (limiteInferior <= limiteSuperior && result == -1) {
            indice = (limiteInferior + limiteSuperior) / 2;

            if (items[indice] == numeroBuscado) {
                System.out.println("Encontrado");
                result = indice;
            } else if (numeroBuscado > items[indice]) {
                limiteInferior = indice + 1;
            } else if (numeroBuscado < items[indice]) {
                limiteSuperior = indice - 1;
            }
        }

        return result;
    }

    //----------------------------
    //----------------------------
    public static int busquedaLineal(int[] items, int numeroBuscado) {
        int result = -1;
        for (int i = 0; i < items.length - 1; i++) {

            if (items[i] == numeroBuscado) {
                System.out.println("Encontrado");
                result = i;
                break;
            }
        }
        return result;
    }

    //------------------------------
    public static void Imprimir(int[] items) {
        System.out.print("Los valores del arreglo son: [ ");
        for (int ind = 0; ind < items.length; ind++) {
            System.out.print(items[ind] + ",  ");
        }
        System.out.println("]");
    }

}
