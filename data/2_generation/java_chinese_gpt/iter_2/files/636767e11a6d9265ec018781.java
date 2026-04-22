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
            return;
        }
        
        // 假设 METRICS 有一个方法 getName() 和 getValue() 
        // 用于获取指标名称和对应的值
        String name = data.getName();
        int value = data.getValue();

        metricsCache.merge(name, value, Integer::sum);
    }
}

// 假设 METRICS 类的定义
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