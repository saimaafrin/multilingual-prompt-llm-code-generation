import java.util.*;

public class GraphPathTransformer {
    
    public List<Integer> setToPath(Set<Edge> tour, Graph graph) {
        if (tour == null || tour.isEmpty() || graph == null) {
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();
        Map<Integer, List<Edge>> adjacencyMap = new HashMap<>();

        // Build adjacency map from edges
        for (Edge edge : tour) {
            adjacencyMap.computeIfAbsent(edge.getSource(), k -> new ArrayList<>()).add(edge);
            adjacencyMap.computeIfAbsent(edge.getDestination(), k -> new ArrayList<>()).add(edge);
        }

        // Start with any vertex that has edges
        int currentVertex = tour.iterator().next().getSource();
        path.add(currentVertex);

        // Build path by following edges
        while (path.size() <= tour.size()) {
            List<Edge> edges = adjacencyMap.get(currentVertex);
            
            // Find unused edge
            Edge nextEdge = null;
            for (Edge edge : edges) {
                if (tour.contains(edge)) {
                    nextEdge = edge;
                    tour.remove(edge);
                    break;
                }
            }

            if (nextEdge == null) {
                break;
            }

            // Add next vertex to path
            currentVertex = (nextEdge.getSource() == currentVertex) ? 
                          nextEdge.getDestination() : nextEdge.getSource();
            path.add(currentVertex);
        }

        return path;
    }
}

// Supporting classes needed for compilation
class Edge {
    private int source;
    private int destination;
    
    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
    
    public int getSource() {
        return source;
    }
    
    public int getDestination() {
        return destination;
    }
}

class Graph {
    private List<Edge> edges;
    
    public Graph() {
        edges = new ArrayList<>();
    }
    
    public void addEdge(Edge edge) {
        edges.add(edge);
    }
    
    public List<Edge> getEdges() {
        return edges;
    }
}