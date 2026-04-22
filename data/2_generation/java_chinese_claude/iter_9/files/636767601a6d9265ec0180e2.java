import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.MinimumSTCutAlgorithm;
import org.jgrapht.alg.flow.EdmondsKarpMFImpl;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class SeparatorFinder<V,E> {

    private Graph<V,E> graph;
    
    public SeparatorFinder(Graph<V,E> g) {
        this.graph = g;
    }

    private List<Pair<List<Pair<Integer,Integer>>,E>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer,Integer>>,E>> globalSeparators = new ArrayList<>();
        
        // For each edge in the graph
        for (E edge : graph.edgeSet()) {
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            
            // Create a working copy of the graph without the current edge
            Graph<V,E> workingGraph = new SimpleGraph<>(graph.getVertexSupplier(), graph.getEdgeSupplier(), false);
            for (V vertex : graph.vertexSet()) {
                workingGraph.addVertex(vertex);
            }
            for (E e : graph.edgeSet()) {
                if (!e.equals(edge)) {
                    workingGraph.addEdge(graph.getEdgeSource(e), graph.getEdgeTarget(e));
                }
            }
            
            // Find minimum separators between source and target
            List<Pair<Integer,Integer>> separators = findMinimumSeparators(workingGraph, source, target);
            
            // Add to global list
            globalSeparators.add(Pair.of(separators, edge));
        }
        
        return globalSeparators;
    }
    
    private List<Pair<Integer,Integer>> findMinimumSeparators(Graph<V,E> g, V source, V target) {
        List<Pair<Integer,Integer>> separators = new ArrayList<>();
        
        // Convert vertices to integers for min cut algorithm
        Map<V,Integer> vertexMap = new HashMap<>();
        int index = 0;
        for (V vertex : g.vertexSet()) {
            vertexMap.put(vertex, index++);
        }
        
        // Create flow network
        SimpleGraph<Integer,DefaultWeightedEdge> flowNetwork = 
            new SimpleGraph<>(DefaultWeightedEdge.class);
            
        // Add vertices
        for (int i = 0; i < vertexMap.size(); i++) {
            flowNetwork.addVertex(i);
        }
        
        // Add edges with weight 1
        for (E e : g.edgeSet()) {
            int v1 = vertexMap.get(g.getEdgeSource(e));
            int v2 = vertexMap.get(g.getEdgeTarget(e));
            DefaultWeightedEdge newEdge = flowNetwork.addEdge(v1, v2);
            if (newEdge != null) {
                flowNetwork.setEdgeWeight(newEdge, 1.0);
            }
        }
        
        // Find min cut
        MinimumSTCutAlgorithm<Integer,DefaultWeightedEdge> minCutAlg = 
            new EdmondsKarpMFImpl<>(flowNetwork);
            
        int s = vertexMap.get(source);
        int t = vertexMap.get(target);
        
        double minCutWeight = minCutAlg.calculateMinCut(s, t);
        Set<Integer> sourcePartition = minCutAlg.getSourcePartition();
        
        // Add separator pairs
        for (Integer v1 : sourcePartition) {
            for (Integer v2 : flowNetwork.vertexSet()) {
                if (!sourcePartition.contains(v2)) {
                    if (flowNetwork.containsEdge(v1, v2)) {
                        separators.add(Pair.of(v1, v2));
                    }
                }
            }
        }
        
        return separators;
    }
}