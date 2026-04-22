import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> {
    private Map<K, V> map;

    public MyMap() {
        this.map = new HashMap<>();
    }

    /**
     * यदि इस मानचित्र में निर्दिष्ट कुंजी के लिए एक मैपिंग है, तो <code>true</code> लौटाएं।
     * @param key  वह कुंजी जिसे खोजा जाना है
     * @return यदि मानचित्र में कुंजी है तो true
     */
    @Override
    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    // Additional methods to put and get values for testing purposes
    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.put("one", 1);
        System.out.println(myMap.containsKey("one")); // true
        System.out.println(myMap.containsKey("two")); // false
    }
}