# 1-PruebaEvaluacion-TecnicasProgramacion-
Repositorio de la primera prueba de evaluacion continua para Tecnicas de Programacion

Enlace al repositorio:
https://github.com/Guilleg8/1-PruebaEvaluacion-TecnicasProgramacion-/tree/main

En el Main se comprueban todos las clases creadas en las distintas practicas a traves de una clase menu intermedia que muestra las opciones de probar las tres practicas. Cada Practica tiene su paquete correspondiente con las clases y archivos que cada una necesita para su correcto funcionamiento. Ademas hay una carpeta uml con los uml individuales de cada practica y un uml completo de todo el programa en conjunto.

Analisis de Complejidad de cada metodo:


- Practica 1 (Clase Matematicas):
  
    generarNumeroPi(int puntosTotales) -> Este metodo tiene una complejidad O(n) dado que el bucle for se ejecuta tantas veces como puntosTotales lo que le otorga una complejidad O(n). El resto de operaciones son O(1).


- Practica 2 (Clase Tablero):
  
    leerEstadoActual() -> Este metodo tiene una complejidad O(1) puesto que el bucle se ejecuta TAMAÑO veces, al ser esta una cantidad fija la complejidad no se incrementa manteniendose en O(1), ya que el resto de operaciones tambien son de complejidad O(1).

    generarEstadoActual() -> Este metodo al igual que el anterior es de complejidad O(1) ya que TAMAÑO es un valor fijo.
  
    leerEstadoSiguietne() -> Este metodo al igual que los dos anteriores es de complejidad O(1) ya que TAMAÑO es un valor fijo.
  
    contarVecinosVivos(int f,int c) -> Este metodo también sería de complejidad O(1) ya que siempre va a revisar la misma cantidad de celdas de la matriz, sin depender de ninguna variable.
  
    toString -> Este metodo es de complejidad O(1) dado que depende de TAMAÑO que no varia.


- Practica 3 (Clase Graph):
  
    addVertex(V vertice) -> Este metodo tiene una complejidad total de O(1) ya que ninguna de sus operaciones supera dicha complejidad.
  
    addEdge(V v1, V v2) -> Al igual que en el anterior este metodo también tiene una complejidad total de O(1).
  
    obtainAdjacent(V v) -> Este metodo tampoco supera en ninguna de sus operaciones la complejidad O(1), por lo que su complejidad total es de O(1).

    containsVertex(V v) -> En este caso y al igual que en los anteriores también se mantendría una complejidad de O(1).
  
    toString -> Este caso es un tanto distinto ya que al querer recorrer todo el grafo para mostrarlo la complejidad depende del número de vértices y de abyacentes de cada uno de ellos por lo que ascenderia a una complejidad O(N+M).
  
    onePath(V v1, V v2) -> Al igual que en el anterior en este metodo se recorre el grafo completo por lo que la complejidad queda sujeta al número de vértices y de sus abyacentes, por lo que su complejidad tmabién seria O(N+M).
