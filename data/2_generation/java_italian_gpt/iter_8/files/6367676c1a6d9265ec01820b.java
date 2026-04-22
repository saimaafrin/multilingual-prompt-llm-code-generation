public class StringCleaner {
    
    /** 
     * Elimina qualsiasi carattere in una Stringa data.
     * @param inString la Stringa originale
     * @param charsToDelete un insieme di caratteri da eliminare. Ad esempio, "az\n" eliminerà le 'a', le 'z' e le nuove righe.
     * @return la Stringa risultante
     */
    public static String deleteAny(String inString, String charsToDelete) {
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (charsToDelete.indexOf(c) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String original = "Hello World! This is a test string.";
        String charsToDelete = "aeiou";
        String cleanedString = deleteAny(original, charsToDelete);
        System.out.println(cleanedString); // Hll Wrld! Ths s  tst strng.
    }
}