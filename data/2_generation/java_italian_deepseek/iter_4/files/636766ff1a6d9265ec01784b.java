public class StringUtils {

    /**
     * <p>Controlla se la <code>String</code> contiene solo caratteri numerici.</p>
     * <p><code>Null</code> e stringhe vuote restituiranno <code>false</code>.</p>
     * @param str  la <code>String</code> da controllare
     * @return <code>true</code> se str contiene solo numeri unicode
     */
    public static boolean isDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isDigits("12345")); // true
        System.out.println(isDigits("123a45")); // false
        System.out.println(isDigits("")); // false
        System.out.println(isDigits(null)); // false
    }
}