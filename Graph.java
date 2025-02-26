import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        return listaadyacentes.containsKey(v);
    }
    
}
