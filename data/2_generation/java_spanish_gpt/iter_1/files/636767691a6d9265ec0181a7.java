public class StringTrimmer {
    
    /** 
     * Elimina todas las ocurrencias del carácter inicial proporcionado de la cadena dada.
     * @param str la cadena a verificar
     * @param leadingCharacter el carácter inicial que se debe eliminar
     * @return la cadena sin el carácter inicial
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        boolean leadingCharFound = false;

        for (char c : str.toCharArray()) {
            if (c == leadingCharacter && !leadingCharFound) {
                continue; // Skip leading character
            }
            leadingCharFound = true; // After the first non-leading character is found
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String testString = "aaabacada";
        char leadingChar = 'a';
        String result = trimLeadingCharacter(testString, leadingChar);
        System.out.println(result); // Output: "bacada"
    }
}