public class BooleanUtils {
    /**
     * 如果 <code>value</code> 为 "真"，则返回 <code>true</code>。如果 <code>value</code> 为 "假"，则返回 <code>false</code>。否则，返回 <code>default</code>。<p>值的大小写不重要。
     */
    public static boolean toBoolean(String value, boolean dEfault) {
        if (value == null) {
            return dEfault;
        }
        
        String trimmedValue = value.trim().toLowerCase();
        
        if (trimmedValue.equals("真")) {
            return true;
        }
        
        if (trimmedValue.equals("假")) {
            return false;
        }
        
        return dEfault;
    }
}