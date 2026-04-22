import java.util.Set;
import java.util.HashSet;

public class Graph<V,E> {
    
    private Set<Edge<V,E>> edges;
    
    /**
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice 
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        
        for(Edge<V,E> e : edges) {
            if(v.contains(e.getDestination())) {
                sum += e.getWeight();
            }
        }
        
        return sum;
    }
    
    // Edge class to represent weighted edges
    private class Edge<V,E> {
        private V source;
        private V destination;
        private double weight;
        private E data;
        
        public Edge(V source, V destination, double weight, E data) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.data = data;
        }
        
        public V getSource() {
            return source;
        }
        
        public V getDestination() {
            return destination;
        }
        
        public double getWeight() {
            return weight;
        }
        
        public E getData() {
            return data;
        }
    }
}