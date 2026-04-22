import java.util.Objects;

public class StringUtils {
    
    public static boolean endsWith(String str, String suffix, boolean ignoreCase) {
        if (str == null || suffix == null) {
            return str == null && suffix == null;
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        int strOffset = str.length() - suffix.length();
        
        if (ignoreCase) {
            return str.regionMatches(true, strOffset, suffix, 0, suffix.length());
        } else {
            return str.regionMatches(false, strOffset, suffix, 0, suffix.length());
        }
    }
}