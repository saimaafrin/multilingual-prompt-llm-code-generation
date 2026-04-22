import org.apache.commons.beanutils.BeanMap;

public class MyBeanMap {

    private Object bean;

    public MyBeanMap(Object bean) {
        this.bean = bean;
    }

    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("Il BeanMap fornito non può essere nullo.");
        }

        BeanMap thisBeanMap = new BeanMap(this.bean);
        for (Object key : map.keySet()) {
            if (thisBeanMap.isWriteable((String) key)) {
                thisBeanMap.put(key, map.get(key));
            }
        }
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        MyBean myBean = new MyBean();
        MyBean anotherBean = new MyBean();

        BeanMap beanMap = new BeanMap(myBean);
        BeanMap anotherBeanMap = new BeanMap(anotherBean);

        // Imposta alcune proprietà scrivibili
        anotherBeanMap.put("property1", "value1");
        anotherBeanMap.put("property2", "value2");

        MyBeanMap myBeanMap = new MyBeanMap(myBean);
        myBeanMap.putAllWriteable(anotherBeanMap);

        // Verifica che le proprietà siano state copiate correttamente
        System.out.println(beanMap.get("property1")); // Output: value1
        System.out.println(beanMap.get("property2")); // Output: value2
    }
}

class MyBean {
    private String property1;
    private String property2;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }
}