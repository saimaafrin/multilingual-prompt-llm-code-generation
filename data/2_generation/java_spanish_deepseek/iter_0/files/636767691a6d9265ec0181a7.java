public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso
        String result = trimLeadingCharacter("aaaaHello", 'a');
        System.out.println(result);  // Output: "Hello"
    }

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

        int index = 0;
        while (index < str.length() && str.charAt(index) == leadingCharacter) {
            index++;
        }

        return str.substring(index);
    }
}