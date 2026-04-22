import java.util.*;

public class Graph {
    // Assume we have an adjacency list representation with Edge objects
    private Map<Vertex, List<Edge>> adjList;
    
    public double computeIncomingWeightSum(Vertex v) {
        double sum = 0.0;
        
        // Iterate through all vertices and their edges
        for (Map.Entry<Vertex, List<Edge>> entry : adjList.entrySet()) {
            List<Edge> edges = entry.getValue();
            
            // Check each edge to see if it points to vertex v
            for (Edge e : edges) {
                if (e.getDestination().equals(v)) {
                    sum += e.getWeight();
                }
            }
        }
        
        return sum;
    }
    
    // Helper classes
    class Vertex {
        private int id;
        
        public Vertex(int id) {
            this.id = id;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return id == vertex.id;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
    
    class Edge {
        private Vertex source;
        private Vertex destination;
        private double weight;
        
        public Edge(Vertex source, Vertex destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        
        public Vertex getSource() {
            return source;
        }
        
        public Vertex getDestination() {
            return destination;
        }
        
        public double getWeight() {
            return weight;
        }
    }
}