package org.example.utils;

public class StringUtils {
    /**
     * Elimina qualsiasi carattere in una Stringa data.
     * @param inString la Stringa originale
     * @param charsToDelete un insieme di caratteri da eliminare. Ad esempio, "az\n" eliminerà le 'a', le 'z' e le nuove righe.
     * @return la Stringa risultante
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }
        
        StringBuilder sb = new StringBuilder(inString.length());
        for (int i = 0; i < inString.length(); i++) {
            char ch = inString.charAt(i);
            if (charsToDelete.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}