import java.util.Objects;

public class StringUtils {

    /**
     * Finds the first index within a String, handling <code>null</code>. 
     * This method uses {@link String#indexOf(String)}.
     *
     * @param str the String to check, may be null
     * @param searchStr the String to find, may be null
     * @return the first index of searchStr in str, -1 if no match or null string input
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }
}