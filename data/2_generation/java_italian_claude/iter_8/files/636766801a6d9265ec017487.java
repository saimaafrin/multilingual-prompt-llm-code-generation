public class TemplateEncoder {
    /**
     * Codifica una stringa con nomi di parametri di template presenti, in particolare i caratteri '{' e '}' verranno codificati in percentuale.
     * @param s la stringa con zero o più nomi di parametri di template
     * @return la stringa con i nomi di parametri di template codificati.
     */
    public static String encodeTemplateNames(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                result.append("%7B");
            } else if (c == '}') {
                result.append("%7D");
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}