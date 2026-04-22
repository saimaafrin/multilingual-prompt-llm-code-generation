import java.util.Stack;

public class DiagnosisReference {
    private static Stack<String> referenceStack = new Stack<>();

    /**
     * इस NDC के शीर्ष पर अंतिम निदान संदर्भ को देखता है बिना उसे हटाए। <p> लौटाई गई मान वह मान है जो अंतिम बार डाला गया था। यदि कोई संदर्भ उपलब्ध नहीं है, तो खाली स्ट्रिंग "" लौटाई जाती है।
     * @return String सबसे आंतरिक निदान संदर्भ।
     */
    public static String peek() {
        if (!referenceStack.isEmpty()) {
            return referenceStack.peek();
        } else {
            return "";
        }
    }

    // Optional: Method to push a reference onto the stack for testing purposes
    public static void pushReference(String reference) {
        referenceStack.push(reference);
    }

    // Optional: Method to clear the stack for testing purposes
    public static void clearStack() {
        referenceStack.clear();
    }

    public static void main(String[] args) {
        // Example usage
        pushReference("Reference1");
        pushReference("Reference2");
        System.out.println(peek()); // Output: Reference2
        clearStack();
        System.out.println(peek()); // Output: ""
    }
}