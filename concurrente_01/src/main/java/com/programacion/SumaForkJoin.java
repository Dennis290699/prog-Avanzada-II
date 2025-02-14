package com.programacion;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static com.programacion.SumaVectorMain.sumaSerial;

class RecursiveTask extends java.util.concurrent.RecursiveTask<Integer>{

    public static final Integer TAMANIO_MINIMO = 10_000;
    private int[] datos;
    private int inicio;
    private int fin;

    public RecursiveTask(int[] datos, int inicio, int fin){
        this.datos = datos;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int sumaSerial(){
        int suma =0;
        for (int i=inicio; i<fin; i++){
            var tmp = Math.log(datos[i]);
            var tmp2 = Math.sin(tmp);
            suma+=datos[i];
        }
        return suma;
    }

    @Override
    protected Integer compute() {

        int tamanio = fin-inicio;
        if (tamanio<TAMANIO_MINIMO){
            return sumaSerial();
        }
        else{
            //dividir en 2 tareas
            //0 ...... 50_000_000
            RecursiveTask izq = new RecursiveTask(datos,inicio, inicio+tamanio/2 );
            RecursiveTask der = new RecursiveTask(datos, inicio+tamanio/2, fin);

            izq.fork();
            der.fork();

            int sumaIzquierda = izq.join();
            int sumaDerecha = der.join();
            return sumaIzquierda + sumaDerecha;

           /* //otra forma que no es serial solo funciona cuando dividimos para 2

            izq.fork();

            int sumaDerecha = der.compute();
            int sumaIzquierda = izq.join();
            return sumaIzquierda + sumaDerecha;*/
        }
    }


}
public class SumaForkJoin {
    public static void main(String[] args) {
        int total = 100_000_000;
        int[] valores = IntStream.rangeClosed(1, total)
                .toArray();
/*
        RecursiveTask task = new RecursiveTask(valores, 0, valores.length);
        Integer suma1 =0;
        long start = System.currentTimeMillis();
        {
            suma1 = task.invoke();

        }
        long end = System.currentTimeMillis();
        System.out.printf("Suma paralela %d, tiempo: %d ns\n" ,suma1, end-start);
*/
        //suma concurrente

        RecursiveTask task = new RecursiveTask(valores, 0, valores.length);
        ForkJoinPool pool = new ForkJoinPool();
        Integer suma1 =0;

        long start = System.currentTimeMillis();
        {
            suma1 = pool.invoke(task);

        }
        long end = System.currentTimeMillis();
        System.out.printf("Suma paralela %d, tiempo: %d ns\n" ,suma1, end-start);

        Integer suma2;
        start = System.currentTimeMillis();
        {
            suma2 = task.sumaSerial();

        }
        end = System.currentTimeMillis();
        System.out.printf("Suma serial %d, tiempo: %d ns\n" ,suma2, end-start);

    }
}
