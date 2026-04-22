import java.util.Set;

public class VertexWeightCalculator<V> {

    /**
     * एक वर्टेक्स में प्रवेश करने वाले भारों का योग निकालें
     * @param v वर्टेक्स
     * @return एक वर्टेक्स में प्रवेश करने वाले भारों का योग
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            // Assuming that the vertex has a method getWeight() that returns its weight
            // You may need to adjust this based on the actual implementation of the vertex class
            sum += ((Vertex) vertex).getWeight();
        }
        return sum;
    }

    // Assuming a Vertex class with a getWeight method
    private static class Vertex {
        private double weight;

        public Vertex(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }
}