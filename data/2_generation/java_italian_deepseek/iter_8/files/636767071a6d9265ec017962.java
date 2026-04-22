import org.apache.commons.beanutils.BeanMap;

public class MyBeanMap {

    private Object bean;

    public MyBeanMap(Object bean) {
        this.bean = bean;
    }

    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("The provided BeanMap cannot be null.");
        }

        BeanMap thisBeanMap = new BeanMap(this.bean);
        for (Object key : map.keySet()) {
            if (thisBeanMap.isWriteable((String) key)) {
                thisBeanMap.put(key, map.get(key));
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        MyBean anotherBean = new MyBean();
        anotherBean.setName("John");
        anotherBean.setAge(30);

        BeanMap anotherBeanMap = new BeanMap(anotherBean);
        MyBeanMap myBeanMap = new MyBeanMap(myBean);

        myBeanMap.putAllWriteable(anotherBeanMap);

        System.out.println("Name: " + myBean.getName()); // Should print "John"
        System.out.println("Age: " + myBean.getAge());   // Should print "30"
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