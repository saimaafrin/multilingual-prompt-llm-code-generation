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
            if (thisBeanMap.isWriteable((String) key)) {
                Object value = map.get(key);
                thisBeanMap.put(key, value);
            }
        }
    }

    // Esempio di utilizzo
    public static void main(String[] args) {
        // Creazione di un BeanMapExample e di un BeanMap
        BeanMapExample example = new BeanMapExample();
        BeanMap map = new BeanMap(new SomeBean());

        // Inserimento delle proprietà scrivibili
        example.putAllWriteable(map);
    }
}

class SomeBean {
    private String property1;
    private int property2;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public int getProperty2() {
        return property2;
    }

    public void setProperty2(int property2) {
        this.property2 = property2;
    }
}