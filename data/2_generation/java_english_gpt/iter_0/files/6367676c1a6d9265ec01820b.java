public class StringManipulator {

    /** 
     * Delete any character in a given String.
     * @param inString the original String
     * @param charsToDelete a set of characters to delete.E.g. "az\n" will delete 'a's, 'z's and new lines.
     * @return the resulting String
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
        return result.toString(); // Return the resulting string
    }

    public static void main(String[] args) {
        String original = "Hello World! This is a test string.";
        String charsToDelete = "aeiou";
        String result = deleteAny(original, charsToDelete);
        System.out.println(result); // Output: Hll Wrld! Ths s  tst strng.
    }
}