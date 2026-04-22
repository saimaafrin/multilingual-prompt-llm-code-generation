public class BooleanConverter {
    
    /** 
     * 如果 <code>value</code> 为 "真"，则返回 <code>true</code>。如果 <code>value</code> 为 "假"，则返回 <code>false</code>。否则，返回 <code>default</code>。<p>值的大小写不重要。  
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        switch (value.toLowerCase()) {
            case "真":
            case "true":
                return true;
            case "假":
            case "false":
                return false;
            default:
                return dEfault;
        }
    }

    public static void main(String[] args) {
        System.out.println(toBoolean("真", false)); // true
        System.out.println(toBoolean("假", true));  // false
        System.out.println(toBoolean("其他", true)); // true
        System.out.println(toBoolean("其他", false)); // false
    }
}