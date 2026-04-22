import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class MetricsAcceptor {
    
    private final ConcurrentHashMap<String, METRICS> metricsCache;
    
    public MetricsAcceptor() {
        this.metricsCache = new ConcurrentHashMap<>();
    }
    
    /**
     * 将数据读入缓存并与现有值合并。此方法不是线程安全的，应避免并发调用。
     * @param data 需要添加的数据。
     */
    @Override
    public void accept(final METRICS data) {
        Objects.requireNonNull(data, "Input metrics data cannot be null");
        
        String key = data.getKey(); // Assuming METRICS has a getKey() method
        
        METRICS existingMetrics = metricsCache.get(key);
        if (existingMetrics == null) {
            metricsCache.put(key, data);
        } else {
            existingMetrics.merge(data); // Assuming METRICS has a merge() method
        }
    }
}