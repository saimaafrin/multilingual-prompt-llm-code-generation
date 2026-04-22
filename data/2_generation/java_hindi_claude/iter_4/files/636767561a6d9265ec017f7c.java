import java.util.*;

public class GraphPathTransformer {
    
    public List<Integer> setToPath(Set<Edge> tour, Graph graph) {
        if (tour == null || tour.isEmpty() || graph == null) {
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();
        Edge currentEdge = tour.iterator().next();
        int currentVertex = currentEdge.getSource();
        path.add(currentVertex);

        while (!tour.isEmpty()) {
            for (Edge edge : tour) {
                if (edge.getSource() == currentVertex) {
                    path.add(edge.getDestination());
                    currentVertex = edge.getDestination();
                    tour.remove(edge);
                    break;
                } else if (edge.getDestination() == currentVertex) {
                    path.add(edge.getSource());
                    currentVertex = edge.getSource();
                    tour.remove(edge);
                    break;
                }
            }
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