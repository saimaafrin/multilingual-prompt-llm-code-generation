public class StringManipulator {

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
        
        int startIndex = 0;
        while (startIndex < str.length() && str.charAt(startIndex) == leadingCharacter) {
            startIndex++;
        }
        
        return str.substring(startIndex);
    }

    public static void main(String[] args) {
        String result = trimLeadingCharacter("aaabbbccc", 'a');
        System.out.println(result); // Output: bbbccc
    }
}