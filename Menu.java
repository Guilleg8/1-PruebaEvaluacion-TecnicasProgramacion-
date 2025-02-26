import practica1.Matematicas;
import practica2.Tablero;
import practica3.Graph;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    Scanner sc = new Scanner(System.in);
    int opcion;
    public Menu() {
        while(opcion!=4){
            System.out.println("\n----MENU----");
            System.out.println("1. Practica 1");
            System.out.println("2. Practica 2");
            System.out.println("3. Practoca 3");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion: ");

            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    //Comprobaciones practica1
                    System.out.println("El número PI es " + Matematicas.
                            generarNumeroPi(200000));
                    break;

                case 2:
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
                    break;

                case 3:
                    //Comprobaciones practica3
                    Graph graph = new Graph();
                    graph.onePathFindsAPath();
            }
        }
    }
}

