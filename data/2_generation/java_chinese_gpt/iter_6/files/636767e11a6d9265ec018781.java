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
            // 假设 METRICS 有一个方法 getKey() 和 getValue()，用于获取键和值
            String key = data.getKey();
            int value = data.getValue();
            metricsCache.merge(key, value, Integer::sum);
        }
    }
}

// 假设 METRICS 类的定义
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

    public int getValue() {
        return value;
    }
}