public class StringUtils {
    /**
     * Rimuove tutte le occorrenze del carattere iniziale fornito dalla Stringa data.
     * @param str la Stringa da controllare
     * @param leadingCharacter il carattere iniziale da rimuovere
     * @return la Stringa ripulita
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        int i = 0;
        while (i < str.length() && str.charAt(i) == leadingCharacter) {
            i++;
        }
        
        return str.substring(i);
    }
}