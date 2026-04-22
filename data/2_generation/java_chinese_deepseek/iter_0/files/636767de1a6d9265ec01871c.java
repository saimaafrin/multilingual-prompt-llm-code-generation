import java.util.HashMap;
import java.util.Map;

public class Accumulator {
    private Map<String, Long> map = new HashMap<>();

    /**
     * 将给定键的值与现有值累加。
     * @param key 键
     * @param value 要累加的值
     */
    public void valueAccumulation(String key, Long value) {
        map.put(key, map.getOrDefault(key, 0L) + value);
    }

    // 可选：提供一个方法来获取当前累加的结果
    public Long getValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator();
        accumulator.valueAccumulation("key1", 10L);
        accumulator.valueAccumulation("key1", 20L);
        System.out.println(accumulator.getValue("key1")); // 输出: 30
    }
}