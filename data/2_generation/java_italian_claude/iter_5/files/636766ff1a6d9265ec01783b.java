public class StringUtils {
    /**
     * Ottiene una sottostringa dalla Stringa specificata evitando eccezioni.
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        
        int length = str.length();
        
        if (start < 0) {
            start = 0;
        }
        
        if (end > length) {
            end = length;
        }
        
        if (start > end) {
            return "";
        }
        
        if (start > length) {
            return "";
        }
        
        return str.substring(start, end);
    }
}