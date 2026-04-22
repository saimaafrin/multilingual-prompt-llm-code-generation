import org.apache.commons.beanutils.BeanMap;

public class BeanMapExample {

    /**
     * Inserisce tutte le proprietà scrivibili dal BeanMap fornito in questo BeanMap. Le proprietà di sola lettura e di sola scrittura verranno ignorate.
     * @param map  il BeanMap le cui proprietà devono essere inserite
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("Il BeanMap fornito non può essere nullo.");
        }

        // Ottieni tutte le chiavi (nomi delle proprietà) dal BeanMap fornito
        for (Object key : map.keySet()) {
            // Verifica se la proprietà è scrivibile
            if (map.isWriteable((String) key)) {
                // Ottieni il valore della proprietà dal BeanMap fornito
                Object value = map.get(key);
                // Imposta il valore della proprietà in questo BeanMap
                this.put(key, value);
            }
        }
    }

    // Metodo put per impostare il valore di una proprietà
    private void put(Object key, Object value) {
        // Implementazione del metodo put per impostare il valore di una proprietà
        // Questo è un esempio, l'implementazione reale dipenderà dalla tua logica specifica
        // Ad esempio, potresti usare un Map interno per memorizzare i valori
        // internalMap.put(key, value);
    }

    // Esempio di utilizzo
    public static void main(String[] args) {
        // Creazione di un BeanMap di esempio
        BeanMap sourceMap = new BeanMap(new MyBean());
        BeanMapExample targetMap = new BeanMapExample();

        // Inserimento delle proprietà scrivibili
        targetMap.putAllWriteable(sourceMap);
    }
}

// Esempio di classe Bean
class MyBean {
    private String name;
    private int age;

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