public class Main {
    /**
     * दिए गए स्ट्रिंग से प्रदान किए गए अग्रणी वर्ण के सभी उदाहरणों को हटाएं।
     * @param str वह स्ट्रिंग जिसे जांचना है
     * @param leadingCharacter वह अग्रणी वर्ण जिसे हटाना है
     * @return हटाई गई स्ट्रिंग
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        int startIndex = 0;
        while (startIndex < str.length() && str.charAt(startIndex) == leadingCharacter) {
            startIndex++;
        }
        return str.substring(startIndex);
    }

    public static void main(String[] args) {
        String result = trimLeadingCharacter("aaaHello World", 'a');
        System.out.println(result); // Output: Hello World
    }
}