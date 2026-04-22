import java.util.HashMap;
import java.util.Map;

public class MetricsCache {
    private Map<String, Integer> cache = new HashMap<>();

    /**
     * 将数据读入缓存并与现有值合并。此方法不是线程安全的，应避免并发调用。
     * @param data 需要添加的数据。
     */
    @Override
    public void accept(final METRICS data) {
        for (Map.Entry<String, Integer> entry : data.getMetrics().entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            cache.put(key, cache.getOrDefault(key, 0) + value);
        }
    }

    // Assuming METRICS is a class that contains a map of metrics
    public static class METRICS {
        private Map<String, Integer> metrics;

        public METRICS(Map<String, Integer> metrics) {
            this.metrics = metrics;
        }

        public Map<String, Integer> getMetrics() {
            return metrics;
        }
    }
}