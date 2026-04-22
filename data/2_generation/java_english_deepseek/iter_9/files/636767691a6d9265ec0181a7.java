public class StringUtils {

    /**
     * Trim all occurrences of the supplied leading character from the given String.
     * @param str the String to check
     * @param leadingCharacter the leading character to be trimmed
     * @return the trimmed String
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null) {
            return null;
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
        System.out.println(trimLeadingCharacter(testString, leadingChar)); // Output: "HelloWorld"
    }
}