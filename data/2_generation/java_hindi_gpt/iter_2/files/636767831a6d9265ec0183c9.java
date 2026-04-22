import java.util.Stack;

public class DiagnosisStack {
    private static Stack<String> diagnosisStack = new Stack<>();

    /** 
     * इस NDC के शीर्ष पर अंतिम निदान संदर्भ को देखता है बिना उसे हटाए। <p> लौटाई गई मान वह मान है जो अंतिम बार डाला गया था। यदि कोई संदर्भ उपलब्ध नहीं है, तो खाली स्ट्रिंग "" लौटाई जाती है।
     * @return String सबसे आंतरिक निदान संदर्भ।
     */
    public static String peek() {
        if (diagnosisStack.isEmpty()) {
            return "";
        }
        return diagnosisStack.peek();
    }

    // Method to push a diagnosis reference onto the stack
    public static void push(String diagnosis) {
        diagnosisStack.push(diagnosis);
    }

    // Method to pop a diagnosis reference from the stack
    public static String pop() {
        if (!diagnosisStack.isEmpty()) {
            return diagnosisStack.pop();
        }
        return "";
    }

    public static void main(String[] args) {
        push("Diagnosis 1");
        push("Diagnosis 2");
        System.out.println(peek()); // Output: Diagnosis 2
        pop();
        System.out.println(peek()); // Output: Diagnosis 1
        pop();
        System.out.println(peek()); // Output: ""
    }
}