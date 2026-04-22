import java.util.*;

public class MinimalSeparators {
    private Graph graph;

    public MinimalSeparators(Graph graph) {
        this.graph = graph;
    }

    public List<Set<Integer>> computeGlobalSeparatorList() {
        List<Set<Integer>> globalSeparators = new ArrayList<>();
        
        // Get all edges from the graph
        Set<Edge> edges = graph.getEdges();
        
        // For each edge, find its minimal separators
        for (Edge e : edges) {
            int u = e.getSource();
            int v = e.getTarget();
            
            // Get neighbors of both vertices
            Set<Integer> uNeighbors = graph.getNeighbors(u);
            Set<Integer> vNeighbors = graph.getNeighbors(v);
            
            // Find common neighbors (potential minimal separators)
            Set<Integer> commonNeighbors = new HashSet<>(uNeighbors);
            commonNeighbors.retainAll(vNeighbors);
            
            // For each common neighbor, check if it forms a minimal separator
            for (Integer w : commonNeighbors) {
                Set<Integer> potentialSeparator = new HashSet<>();
                potentialSeparator.add(w);
                
                // Check if removing potentialSeparator disconnects u and v
                if (isMinimalSeparator(u, v, potentialSeparator)) {
                    globalSeparators.add(new HashSet<>(potentialSeparator));
                }
            }
            
            // Check pairs of common neighbors
            List<Integer> neighborsList = new ArrayList<>(commonNeighbors);
            for (int i = 0; i < neighborsList.size(); i++) {
                for (int j = i + 1; j < neighborsList.size(); j++) {
                    Set<Integer> potentialSeparator = new HashSet<>();
                    potentialSeparator.add(neighborsList.get(i));
                    potentialSeparator.add(neighborsList.get(j));
                    
                    if (isMinimalSeparator(u, v, potentialSeparator)) {
                        globalSeparators.add(new HashSet<>(potentialSeparator));
                    }
                }
            }
        }
        
        return globalSeparators;
    }
    
    private boolean isMinimalSeparator(int source, int target, Set<Integer> separator) {
        // Create a graph copy without the separator vertices
        Graph reducedGraph = graph.copy();
        for (Integer v : separator) {
            reducedGraph.removeVertex(v);
        }
        
        // Check if source and target are disconnected
        return !hasPath(reducedGraph, source, target);
    }
    
    private boolean hasPath(Graph g, int source, int target) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target) {
                return true;
            }
            
            for (Integer neighbor : g.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return false;
    }
    
    // Helper class to represent graph edges
    private static class Edge {
        private int source;
        private int target;
        
        public Edge(int source, int target) {
            this.source = source;
            this.target = target;
        }
        
        public int getSource() {
            return source;
        }
        
        public int getTarget() {
            return target;
        }
    }
    
    // Interface for the graph implementation
    private interface Graph {
        Set<Edge> getEdges();
        Set<Integer> getNeighbors(int vertex);
        void removeVertex(int vertex);
        Graph copy();
    }
}