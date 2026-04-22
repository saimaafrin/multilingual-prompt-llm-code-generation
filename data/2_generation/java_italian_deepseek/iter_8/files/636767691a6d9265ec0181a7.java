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

        int index = 0;
        while (index < str.length() && str.charAt(index) == leadingCharacter) {
            index++;
        }

        return str.substring(index);
    }

    public static void main(String[] args) {
        String testString = "###HelloWorld";
        char leadingChar = '#';
        String result = trimLeadingCharacter(testString, leadingChar);
        System.out.println(result);  // Output: "HelloWorld"
    }
}