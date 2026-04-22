public class StringUtils {
    
    /** 
     * Devuelve el número de ocurrencias de la subcadena {@code sub} en la cadena {@code str}.
     * @param str cadena en la que buscar. Devuelve 0 si es nula.
     * @param sub cadena a buscar. Devuelve 0 si es nula.
     * @return el número de ocurrencias de la subcadena {@code sub} en la cadena {@code str}.
     */
    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || sub.length() == 0) {
            return 0;
        }
        
        int count = 0;
        int pos = 0;
        int idx;
        
        while ((idx = str.indexOf(sub, pos)) != -1) {
            count++;
            pos = idx + sub.length();
        }
        
        return count;
    }
}