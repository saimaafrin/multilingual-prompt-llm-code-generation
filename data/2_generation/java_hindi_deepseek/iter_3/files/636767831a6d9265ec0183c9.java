import java.util.Stack;

public class NDC {

    private static Stack<String> ndcStack = new Stack<>();

    /**
     * इस NDC के शीर्ष पर अंतिम निदान संदर्भ को देखता है बिना उसे हटाए। <p> लौटाई गई मान वह मान है जो अंतिम बार डाला गया था। यदि कोई संदर्भ उपलब्ध नहीं है, तो खाली स्ट्रिंग "" लौटाई जाती है।
     * @return String सबसे आंतरिक निदान संदर्भ।
     */
    public static String peek() {
        if (!ndcStack.isEmpty()) {
            return ndcStack.peek();
        } else {
            return "";
        }
    }

    // Optional: Method to push a new reference onto the stack
    public static void push(String reference) {
        ndcStack.push(reference);
    }

    // Optional: Method to pop the top reference from the stack
    public static String pop() {
        if (!ndcStack.isEmpty()) {
            return ndcStack.pop();
        } else {
            return "";
        }
    }
}