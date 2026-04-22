import org.apache.commons.beanutils.BeanMap;

public class BeanMapUtils {

    /**
     * 将给定 BeanMap 中所有可写属性放入此 BeanMap。只读和只写属性将被忽略。
     * @param map  要放入的 BeanMap
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("The input BeanMap cannot be null.");
        }

        // 获取当前 BeanMap 的所有可写属性
        for (Object key : map.keySet()) {
            if (map.isWriteable(key.toString())) {
                Object value = map.get(key);
                this.put(key, value);
            }
        }
    }

    // 假设 BeanMap 的 put 方法已经存在
    public void put(Object key, Object value) {
        // 这里假设 BeanMap 的 put 方法已经实现
        // 实际实现可能依赖于具体的 BeanMap 实现
    }

    public static void main(String[] args) {
        // 示例用法
        BeanMap sourceMap = new BeanMap(new MyBean());
        BeanMap targetMap = new BeanMap(new MyBean());

        // 假设 sourceMap 已经被填充了一些数据
        BeanMapUtils utils = new BeanMapUtils();
        utils.putAllWriteable(sourceMap);
    }
}

class MyBean {
    private String name;
    private int age;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}