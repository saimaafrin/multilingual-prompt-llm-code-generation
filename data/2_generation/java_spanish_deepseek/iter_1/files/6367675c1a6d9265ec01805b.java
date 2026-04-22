// Asumiendo que la clase que contiene este método tiene referencias a las listas doblemente enlazadas de bordes.
// También asumimos que la clase tiene un campo `edge` que representa el borde actual.

public class Tree {
    private Edge edge; // El borde actual que se va a eliminar
    private List<Edge> edgeList1; // Primera lista doblemente enlazada de bordes
    private List<Edge> edgeList2; // Segunda lista doblemente enlazada de bordes

    public Tree(Edge edge, List<Edge> edgeList1, List<Edge> edgeList2) {
        this.edge = edge;
        this.edgeList1 = edgeList1;
        this.edgeList2 = edgeList2;
    }

    public void removeFromTreeEdgeList() {
        // Eliminar el borde de la primera lista
        edgeList1.remove(edge);

        // Eliminar el borde de la segunda lista
        edgeList2.remove(edge);
    }
}

// Clase Edge para representar un borde en el árbol
class Edge {
    private int source;
    private int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    // Getters y setters (opcional, dependiendo de la implementación)
    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    // Método equals y hashCode para permitir la eliminación correcta de la lista
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return source == edge.source && destination == edge.destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }
}

// Ejemplo de uso
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Edge edge = new Edge(1, 2);
        List<Edge> edgeList1 = new ArrayList<>();
        List<Edge> edgeList2 = new ArrayList<>();

        edgeList1.add(edge);
        edgeList2.add(edge);

        Tree tree = new Tree(edge, edgeList1, edgeList2);
        tree.removeFromTreeEdgeList();

        System.out.println("EdgeList1 size after removal: " + edgeList1.size());
        System.out.println("EdgeList2 size after removal: " + edgeList2.size());
    }
}