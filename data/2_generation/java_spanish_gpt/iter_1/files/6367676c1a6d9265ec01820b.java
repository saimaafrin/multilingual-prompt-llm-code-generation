public class StringManipulator {

    /** 
     * Elimina cualquier carácter en una cadena dada.
     * @param inString la cadena original
     * @param charsToDelete un conjunto de caracteres a eliminar. Por ejemplo, "az\n" eliminará las 'a', 'z' y los saltos de línea.
     * @return la cadena resultante
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString; // Return original string if input is null
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (charsToDelete.indexOf(c) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String original = "Hello World!";
        String charsToRemove = "lo";
        String result = deleteAny(original, charsToRemove);
        System.out.println(result); // Output: "He Wr!"
    }
}