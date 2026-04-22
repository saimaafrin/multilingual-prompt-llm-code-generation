import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> extends HashMap<K, V> {
    
    /**
     * यदि इस मानचित्र में निर्दिष्ट कुंजी के लिए एक मैपिंग है, तो <code>true</code> लौटाएं।
     * @param key  वह कुंजी जिसे खोजा जाना है
     * @return यदि मानचित्र में कुंजी है तो true
     */
    @Override 
    public boolean containsKey(final Object key) {
        return super.containsKey(key);
    }

    public static void main(String[] args) {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.put("one", 1);
        myMap.put("two", 2);
        
        System.out.println(myMap.containsKey("one")); // true
        System.out.println(myMap.containsKey("three")); // false
    }
}