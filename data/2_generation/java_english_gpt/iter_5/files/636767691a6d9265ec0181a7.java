public class StringTrimmer {
    
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
        
        int startIndex = 0;
        while (startIndex < str.length() && str.charAt(startIndex) == leadingCharacter) {
            startIndex++;
        }
        
        return str.substring(startIndex);
    }

    public static void main(String[] args) {
        String result = trimLeadingCharacter("aaaHello World", 'a');
        System.out.println(result); // Output: "Hello World"
    }
}