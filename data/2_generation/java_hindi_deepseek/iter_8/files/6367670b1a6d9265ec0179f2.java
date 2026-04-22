import java.util.Map;

public class CustomMap<K, V> implements Map<K, V> {
    // Assuming this class has a backing map implementation
    private final Map<K, V> backingMap;

    public CustomMap(Map<K, V> backingMap) {
        this.backingMap = backingMap;
    }

    /**
     * यदि इस मानचित्र में निर्दिष्ट कुंजी के लिए एक मैपिंग है, तो <code>true</code> लौटाएं।
     * @param key  वह कुंजी जिसे खोजा जाना है
     * @return यदि मानचित्र में कुंजी है तो true
     */
    @Override
    public boolean containsKey(final Object key) {
        return backingMap.containsKey(key);
    }

    // Other methods of the Map interface would need to be implemented here
}