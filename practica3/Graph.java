package practica3;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class Graph<V> {
    private Map<V, Set<V>> listaadyacentes = new HashMap<>();

    public boolean addVertex(V vertice) {
        if(!listaadyacentes.containsKey(vertice)) {
            listaadyacentes.put(vertice, new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        if(!listaadyacentes.get(v1).contains(v2)) {
            listaadyacentes.get(v1).add(v2);
            return true;
        }
        return false;
    }

    public Set<V> obtainAdjacent(V v) throws Exception {
        if(!listaadyacentes.containsKey(v)) {
            throw new Exception("Vertices no encontrados");
        }
        return listaadyacentes.get(v);
    }

    public boolean containsVertex(V v) {
        if(listaadyacentes.containsKey(v)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<V, Set<V>> entry : listaadyacentes.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    public List<V> onePath(V v1, V v2) {
        if(!containsVertex(v1) || !containsVertex(v2)){
            return null;
        }
        Map<V, V> traza = new HashMap<>();
        Stack<V> abierta = new Stack<>();
        abierta.push(v1);
        traza.put(v1, null);
        boolean encontrado = false;

        while(!abierta.isEmpty() && !encontrado) {
            V v = abierta.pop();
            if(v.equals(v2)) {
                encontrado = true;
            }
            else{
                for(V s : listaadyacentes.get(v)) {
                    if(!traza.containsKey(s)) {
                        abierta.push(s);
                        traza.put(s, v);
                    }
                }
            }
        }
        if(encontrado) {
            List<V> camino = new ArrayList<>();
            for(V paso=v2; paso!=null; paso=traza.get(paso)) {
                camino.add(paso);
            }
            Collections.reverse(camino);
            return camino;
        }
        return null;
    }

    @Test
    public void onePathFindsAPath(){
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");
// Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
// Se construye el camino esperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);
//Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
    }
}
