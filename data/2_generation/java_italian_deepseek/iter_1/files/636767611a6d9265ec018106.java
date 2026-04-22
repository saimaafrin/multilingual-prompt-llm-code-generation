import java.util.Set;

public class GraphUtils<V> {

    /**
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the vertices have a method getIncomingWeight() that returns the weight of incoming edges
        for (V vertex : v) {
            sum += ((Vertex) vertex).getIncomingWeight();
        }
        return sum;
    }

    // Assuming a Vertex class with a method getIncomingWeight()
    private class Vertex {
        private double incomingWeight;

        public Vertex(double incomingWeight) {
            this.incomingWeight = incomingWeight;
        }

        public double getIncomingWeight() {
            return incomingWeight;
        }
    }
}