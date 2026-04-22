import org.apache.commons.beanutils.BeanMap;

public class CustomBeanMap {

    private Object bean;

    public CustomBeanMap(Object bean) {
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
        MyBean bean1 = new MyBean();
        MyBean bean2 = new MyBean();

        bean1.setName("Bean1");
        bean1.setAge(25);

        bean2.setName("Bean2");
        bean2.setAge(30);

        BeanMap beanMap1 = new BeanMap(bean1);
        CustomBeanMap customBeanMap = new CustomBeanMap(bean2);

        customBeanMap.putAllWriteable(beanMap1);

        System.out.println("Bean2 dopo putAllWriteable: " + bean2.getName() + ", " + bean2.getAge());
    }
}

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