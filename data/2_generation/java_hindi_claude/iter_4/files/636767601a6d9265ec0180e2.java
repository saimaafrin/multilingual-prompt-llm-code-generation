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
            List<Integer> commonNeighborsList = new ArrayList<>(commonNeighbors);
            for (int i = 0; i < commonNeighborsList.size(); i++) {
                for (int j = i + 1; j < commonNeighborsList.size(); j++) {
                    Set<Integer> potentialSeparator = new HashSet<>();
                    potentialSeparator.add(commonNeighborsList.get(i));
                    potentialSeparator.add(commonNeighborsList.get(j));
                    
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
        Graph tempGraph = graph.copy();
        for (Integer v : separator) {
            tempGraph.removeVertex(v);
        }
        
        // Check if source and target are disconnected
        return !hasPath(tempGraph, source, target, new HashSet<>());
    }
    
    private boolean hasPath(Graph g, int current, int target, Set<Integer> visited) {
        if (current == target) return true;
        visited.add(current);
        
        for (Integer neighbor : g.getNeighbors(current)) {
            if (!visited.contains(neighbor)) {
                if (hasPath(g, neighbor, target, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    // Helper classes
    
    class Edge {
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
    
    class Graph {
        private Map<Integer, Set<Integer>> adjacencyList;
        
        public Graph() {
            adjacencyList = new HashMap<>();
        }
        
        public Set<Edge> getEdges() {
            Set<Edge> edges = new HashSet<>();
            for (int v : adjacencyList.keySet()) {
                for (int u : adjacencyList.get(v)) {
                    if (v < u) { // avoid duplicates
                        edges.add(new Edge(v, u));
                    }
                }
            }
            return edges;
        }
        
        public Set<Integer> getNeighbors(int vertex) {
            return adjacencyList.getOrDefault(vertex, new HashSet<>());
        }
        
        public void removeVertex(int vertex) {
            // Remove vertex and all its edges
            adjacencyList.remove(vertex);
            for (Set<Integer> neighbors : adjacencyList.values()) {
                neighbors.remove(vertex);
            }
        }
        
        public Graph copy() {
            Graph newGraph = new Graph();
            for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
                newGraph.adjacencyList.put(entry.getKey(), new HashSet<>(entry.getValue()));
            }
            return newGraph;
        }
    }
}