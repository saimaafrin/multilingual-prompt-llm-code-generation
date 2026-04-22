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
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value);
        } else {
            map.put(key, value);
        }
    }

    // 可选：提供一个方法来获取当前累加的结果
    public Long getValue(String key) {
        return map.getOrDefault(key, 0L);
    }

    // 可选：提供一个方法来获取整个累加器的状态
    public Map<String, Long> getMap() {
        return new HashMap<>(map);
    }
}