package com.programacion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class TareaContarPrimos extends RecursiveTask<Integer> {
    private static final int TAM_MINIMO = 10000;
    private final int inicio, fin;

    public TareaContarPrimos(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    private int contarPrimosSerial() {
        int contador = 0;
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    protected Integer compute() {
        int rango = fin - inicio;
        if (rango < TAM_MINIMO) {
            return contarPrimosSerial();
        } else {
            int medio = inicio + rango / 2;
            TareaContarPrimos tareaIzquierda = new TareaContarPrimos(inicio, medio);
            TareaContarPrimos tareaDerecha = new TareaContarPrimos(medio + 1, fin);

            tareaIzquierda.fork();
            int resultadoDerecha = tareaDerecha.compute();
            int resultadoIzquierda = tareaIzquierda.join();

            return resultadoIzquierda + resultadoDerecha;
        }
    }

    // Metodo para determinar si un numero es primo
    public static boolean esPrimo(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

public class ContadorNumerosPrimos {
    public static void main(String[] args) {
        int N = 100_000_000; // Cantidad de numeros

        // Imprimir los nucleos disponibles de la maquina
        System.out.println("Nucleos disponibles: " + Runtime.getRuntime().availableProcessors());

        // Version serial, usando un bucle for directamente
        long inicioTiempo = System.currentTimeMillis();
        int cuentaSerial = 0;
        for (int i = 1; i <= N; i++) {
            if (TareaContarPrimos.esPrimo(i)) {
                cuentaSerial++;
            }
        }
        long finTiempo = System.currentTimeMillis();
        System.out.printf("Serial: %d primos, tiempo: %d ms%n", cuentaSerial, finTiempo - inicioTiempo);

        // Version concurrente con Fork-Join
        ForkJoinPool pool = new ForkJoinPool();
        TareaContarPrimos tarea = new TareaContarPrimos(1, N);
        inicioTiempo = System.currentTimeMillis();
        int cuentaConcurrente = pool.invoke(tarea);
        finTiempo = System.currentTimeMillis();
        System.out.printf("Concurrente: %d primos, tiempo: %d ms%n", cuentaConcurrente, finTiempo - inicioTiempo);
    }
}