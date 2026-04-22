public class StringManipulator {

    /** 
     * दिए गए String में से किसी भी चरित्र को हटाएं।
     * @param inString मूल String
     * @param charsToDelete हटाने के लिए चरित्रों का सेट। उदाहरण के लिए, "az\n" 'a', 'z' और नए लाइनों को हटा देगा।
     * @return परिणामस्वरूप String
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString; // Return original string if input is null
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (charsToDelete.indexOf(c) == -1) {
                result.append(c); // Append character if it's not in charsToDelete
            }
        }
        return result.toString(); // Return the modified string
    }

    public static void main(String[] args) {
        String original = "Hello World!";
        String charsToRemove = "lo";
        String modified = deleteAny(original, charsToRemove);
        System.out.println(modified); // Output: He Wrld!
    }
}