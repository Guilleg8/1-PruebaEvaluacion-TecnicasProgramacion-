import practica1.Matematicas;
import practica2.Tablero;
import practica3.Graph;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        //Comprobaciones practica1
        System.out.println("El número PI es " + Matematicas.
                generarNumeroPi(200000));

        //Comprobaciones practica2
        try {
            Tablero tablero = new Tablero();
            System.out.println("Simulacio tablero leido:");
            tablero.leerEstadoActual();
            System.out.println(tablero);
            for (int i = 0; i <= 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("----------------------------------------------");
                tablero.leerEstadoSiguiente();
                System.out.println(tablero);
            }
            System.out.println("Simulacio tablero Montecarlo");
            tablero.generarEstadoActual();
            System.out.println(tablero);
            for (int i = 0; i <= 15; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("----------------------------------------------");
                tablero.leerEstadoSiguiente();
                System.out.println(tablero);
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }

        //Comprobaciones practica3
        Graph graph = new Graph();
        graph.onePathFindsAPath();
    }
}
