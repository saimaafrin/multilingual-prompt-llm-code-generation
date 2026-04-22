public class ObjectToStringConverter {

    /** 
     * 对象转字符串，当对象为空时返回空字符串，否则返回toString(); 
     */
    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }

    public static void main(String[] args) {
        Object obj1 = null;
        Object obj2 = new Object();
        
        System.out.println("Result for null object: '" + toString(obj1) + "'");
        System.out.println("Result for non-null object: '" + toString(obj2) + "'");
    }
}