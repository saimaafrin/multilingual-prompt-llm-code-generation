import java.util.Objects;

public class StringUtils {

    /**
     * <p>Checks whether the <code>String</code> contains only digit characters.</p>
     * <p><code>Null</code> and empty String will return <code>false</code>.</p>
     * @param str  the <code>String</code> to check
     * @return <code>true</code> if str contains only unicode numeric
     */
    public static boolean isDigits(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}