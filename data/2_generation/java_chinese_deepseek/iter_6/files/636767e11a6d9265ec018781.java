import java.util.HashMap;
import java.util.Map;

public class MetricsCache {
    private Map<String, Double> cache = new HashMap<>();

    /**
     * 将数据读入缓存并与现有值合并。此方法不是线程安全的，应避免并发调用。
     * @param data 需要添加的数据。
     */
    @Override
    public void accept(final METRICS data) {
        for (Map.Entry<String, Double> entry : data.getMetrics().entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            cache.merge(key, value, Double::sum);
        }
    }

    // Assuming METRICS is a class that contains a map of metrics
    public static class METRICS {
        private Map<String, Double> metrics;

        public METRICS(Map<String, Double> metrics) {
            this.metrics = metrics;
        }

        public Map<String, Double> getMetrics() {
            return metrics;
        }
    }

    public static void main(String[] args) {
        MetricsCache cache = new MetricsCache();
        Map<String, Double> data = new HashMap<>();
        data.put("metric1", 10.0);
        data.put("metric2", 20.0);
        METRICS metrics = new METRICS(data);
        cache.accept(metrics);
        System.out.println(cache.cache);
    }
}