import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<String, METRICS> cacheMap = new HashMap<>();

    /**
     * कैश में डेटा स्वीकार करें और मौजूदा मान के साथ विलय करें। यह विधि थ्रेड-सुरक्षित नहीं है, इसे समवर्ती कॉलिंग से बचना चाहिए।
     * @param data जिसे संभावित रूप से जोड़ा जाना है।
     */
    @Override
    public void accept(final METRICS data) {
        String key = data.getKey(); // Assuming METRICS has a method getKey()
        if (cacheMap.containsKey(key)) {
            METRICS existingData = cacheMap.get(key);
            existingData.merge(data); // Assuming METRICS has a method merge()
        } else {
            cacheMap.put(key, data);
        }
    }
}

class METRICS {
    private String key;
    private int value;

    public METRICS(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void merge(METRICS other) {
        this.value += other.value;
    }

    public int getValue() {
        return value;
    }
}