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
        if (data != null) {
            for (Map.Entry<String, Integer> entry : data.getMetrics().entrySet()) {
                metricsCache.merge(entry.getKey(), entry.getValue(), Integer::sum);
            }
        }
    }
}

class METRICS {
    private final Map<String, Integer> metrics;

    public METRICS(Map<String, Integer> metrics) {
        this.metrics = metrics;
    }

    public Map<String, Integer> getMetrics() {
        return metrics;
    }
}