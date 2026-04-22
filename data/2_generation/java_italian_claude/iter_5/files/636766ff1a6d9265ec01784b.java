import java.util.Objects;

public class StringUtils {

    /**
     * <p>Controlla se la <code>String</code> contiene solo caratteri numerici.</p>
     * <p><code>Null</code> e stringhe vuote restituiranno <code>false</code>.</p>
     * @param str la <code>String</code> da controllare
     * @return <code>true</code> se str contiene solo numeri unicode
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