public class ObjectToStringConverter {

    /** 
     * 对象转字符串，当对象为空时返回空字符串，否则返回toString(); 
     */
    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    public static void main(String[] args) {
        Object obj1 = null;
        Object obj2 = new Object() {
            @Override
            public String toString() {
                return "Custom Object String";
            }
        };

        System.out.println(toString(obj1)); // Output: ""
        System.out.println(toString(obj2)); // Output: "Custom Object String"
    }
}