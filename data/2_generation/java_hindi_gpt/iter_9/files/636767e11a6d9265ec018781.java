import java.util.HashMap;
import java.util.Map;

public class MetricsCache {
    private final Map<String, Integer> cache = new HashMap<>();

    /** 
     * कैश में डेटा स्वीकार करें और मौजूदा मान के साथ विलय करें। यह विधि थ्रेड-सुरक्षित नहीं है, इसे समवर्ती कॉलिंग से बचना चाहिए।
     * @param data जिसे संभावित रूप से जोड़ा जाना है।
     */
    @Override 
    public void accept(final METRICS data) {
        // Assuming METRICS has a method getKey() to get the key and getValue() to get the value
        String key = data.getKey();
        int value = data.getValue();

        // Merge the value with the existing value in the cache
        cache.merge(key, value, Integer::sum);
    }
    
    // Assuming a METRICS class for demonstration purposes
    public static class METRICS {
        private final String key;
        private final int value;

        public METRICS(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}