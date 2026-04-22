import org.apache.commons.beanutils.BeanMap;

public class MyBeanMap {

    private BeanMap beanMap;

    public MyBeanMap(Object bean) {
        this.beanMap = new BeanMap(bean);
    }

    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("The provided BeanMap cannot be null.");
        }

        for (Object key : map.keySet()) {
            if (beanMap.isWriteable((String) key)) {
                beanMap.put(key, map.get(key));
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        MyBean anotherBean = new MyBean();

        MyBeanMap myBeanMap = new MyBeanMap(myBean);
        BeanMap anotherBeanMap = new BeanMap(anotherBean);

        // Assuming MyBean has some properties
        anotherBeanMap.put("property1", "value1");
        anotherBeanMap.put("property2", "value2");

        myBeanMap.putAllWriteable(anotherBeanMap);

        // Now myBean should have the properties from anotherBean
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