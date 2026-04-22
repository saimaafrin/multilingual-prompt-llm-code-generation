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

        BeanMap thisBeanMap = new BeanMap(this);

        for (Object key : map.keySet()) {
            if (thisBeanMap.isWriteable((String) key) && map.isReadable((String) key)) {
                Object value = map.get(key);
                thisBeanMap.put(key, value);
            }
        }
    }

    // Esempio di utilizzo
    public static void main(String[] args) {
        // Creazione di un BeanMap per un oggetto di esempio
        BeanMapExample example = new BeanMapExample();
        BeanMap sourceMap = new BeanMap(new ExampleBean());

        // Inserimento delle proprietà scrivibili
        example.putAllWriteable(sourceMap);
    }
}

class ExampleBean {
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