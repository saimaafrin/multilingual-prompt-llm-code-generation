import java.util.HashMap;
import java.util.Map;

public class MetricsHandler implements java.util.function.Consumer<METRICS> {
    private final Map<String, Integer> metricsCache = new HashMap<>();

    /**
     * 将数据读入缓存并与现有值合并。此方法不是线程安全的，应避免并发调用。
     * @param data 需要添加的数据。
     */
    @Override
    public void accept(final METRICS data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        
        // Assuming METRICS has a method getName() and getValue()
        String name = data.getName();
        int value = data.getValue();
        
        metricsCache.merge(name, value, Integer::sum);
    }
}

// Assuming a METRICS class exists
class METRICS {
    private String name;
    private int value;

    public METRICS(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}