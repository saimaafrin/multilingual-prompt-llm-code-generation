public class StringTrimmer {
    /**
     * दिए गए स्ट्रिंग से प्रदान किए गए अग्रणी वर्ण के सभी उदाहरणों को हटाएं।
     * @param str वह स्ट्रिंग जिसे जांचना है
     * @param leadingCharacter वह अग्रणी वर्ण जिसे हटाना है
     * @return हटाई गई स्ट्रिंग
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
        String input = "###HelloWorld";
        char leadingChar = '#';
        String result = trimLeadingCharacter(input, leadingChar);
        System.out.println(result);  // Output: HelloWorld
    }
}