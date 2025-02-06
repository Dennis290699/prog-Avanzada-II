package com.programacion;

import java.util.concurrent.Callable;

public class SumaMultiHilosMain {

    static class ResultHolder {
        Integer[] sumas = new Integer[8]; // Almacenar los resultados de 8 hilos
    }

    static Integer sumaSerial(int[] datos) {
        int suma = 0;
        for (int i = 0; i < datos.length; i++) {
            suma = suma + datos[i];
        }
        return suma;
    }

    static Integer sumaThreads(int[] datos) throws Exception {

        int numHilos = 8;
        int tamanio = datos.length / numHilos;

        SumaTask[] tasks = new SumaTask[numHilos];
        Thread[] threads = new Thread[numHilos];
        final ResultHolder result = new ResultHolder();

        // Inicializar las sumas parciales
        for (int i = 0; i < numHilos; i++) {
            result.sumas[i] = 0;
        }

        // Crear y ejecutar los hilos
        for (int i = 0; i < numHilos; i++) {
            int inicio = i * tamanio;
            int fin = (i == numHilos - 1) ? datos.length : (i + 1) * tamanio;

            tasks[i] = new SumaTask(datos, inicio, fin);
            final int hiloIndex = i;
            threads[i] = new Thread(() -> {
                result.sumas[hiloIndex] = tasks[hiloIndex].call();
            });
            threads[i].start();
        }

        // Esperar a que terminen todos los hilos
        for (Thread t : threads) {
            t.join();
        }

        // Sumar los resultados parciales
        int sumaTotal = 0;
        for (int suma : result.sumas) {
            sumaTotal += suma;
        }

        return sumaTotal;
    }

    static class SumaTask implements Callable<Integer> {
        private int[] data;
        private int start;
        private int end;

        SumaTask(int[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            System.out.printf("[%s] Inicio calculando suma, start: %d, end: %d\n",
                    Thread.currentThread().getName(), start, end);
            try {
                Thread.sleep(10_000); // Simular procesamiento largo
            } catch (Exception e) {
            }
            int suma = 0;
            for (int i = start; i < end; i++) {
                suma = suma + data[i];
            }
            System.out.printf("[%s] Fin calculando suma, start: %d, end: %d\n",
                    Thread.currentThread().getName(), start, end);
            return suma;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] vector = new int[1_000];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = i;
        }

        int suma = sumaThreads(vector);
        System.out.println("Suma total: " + suma);
    }
}
