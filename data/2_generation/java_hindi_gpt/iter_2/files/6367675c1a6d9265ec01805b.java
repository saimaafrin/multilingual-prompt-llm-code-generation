import java.util.LinkedList;

public class TreeEdgeRemover {
    private LinkedList<Edge> edgeList1;
    private LinkedList<Edge> edgeList2;

    public TreeEdgeRemover() {
        edgeList1 = new LinkedList<>();
        edgeList2 = new LinkedList<>();
    }

    /** 
     * इस किनारे को पेड़ के किनारों की दोनों डबल लिंक्ड सूचियों से हटा देता है।
     */
    public void removeFromTreeEdgeList(Edge edgeToRemove) {
        edgeList1.remove(edgeToRemove);
        edgeList2.remove(edgeToRemove);
    }

    // Assuming Edge is a class that represents an edge in the tree
    public static class Edge {
        private int start;
        private int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // Getters, setters, equals, and hashCode methods can be added here
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Edge edge = (Edge) obj;
            return start == edge.start && end == edge.end;
        }

        @Override
        public int hashCode() {
            return 31 * start + end;
        }
    }
}