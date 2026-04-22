public class StringTrimmer {
    
    /** 
     * दिए गए स्ट्रिंग से प्रदान किए गए अग्रणी वर्ण के सभी उदाहरणों को हटाएं।
     * @param str वह स्ट्रिंग जिसे जांचना है
     * @param leadingCharacter वह अग्रणी वर्ण जिसे हटाना है
     * @return हटाई गई स्ट्रिंग
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder();
        boolean leadingCharFound = false;

        for (char c : str.toCharArray()) {
            if (c == leadingCharacter && !leadingCharFound) {
                continue; // Skip leading character
            }
            leadingCharFound = true; // Mark that we have found a non-leading character
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "aaaHello Worldaaa";
        char leadingCharacter = 'a';
        String trimmedString = trimLeadingCharacter(str, leadingCharacter);
        System.out.println(trimmedString); // Output: "Hello Worldaaa"
    }
}