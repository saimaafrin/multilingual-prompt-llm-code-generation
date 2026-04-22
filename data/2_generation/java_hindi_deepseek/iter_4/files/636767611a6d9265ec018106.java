import java.util.Set;

public class GraphUtils {

    /**
     * एक वर्टेक्स में प्रवेश करने वाले भारों का योग निकालें
     * @param v वर्टेक्स
     * @return एक वर्टेक्स में प्रवेश करने वाले भारों का योग
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            sum += vertex.getWeight(); // Assuming V has a method getWeight() to retrieve the weight
        }
        return sum;
    }
}

// Assuming the V class is defined as follows:
class V {
    private double weight;

    public V(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}