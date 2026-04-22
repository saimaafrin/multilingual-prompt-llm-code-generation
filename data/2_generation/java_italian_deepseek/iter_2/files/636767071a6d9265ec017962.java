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
        beanMap.put("name", "John");
        beanMap.put("age", 30);

        MyBeanMap myBeanMap = new MyBeanMap(anotherBean);
        myBeanMap.putAllWriteable(beanMap);

        System.out.println("Name: " + anotherBean.getName());
        System.out.println("Age: " + anotherBean.getAge());
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