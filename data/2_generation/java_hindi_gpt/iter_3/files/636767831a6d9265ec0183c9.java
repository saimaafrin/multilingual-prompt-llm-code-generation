import java.util.Stack;

public class DiagnosisReference {
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

    // Method to add a diagnosis reference for testing purposes
    public static void push(String diagnosis) {
        diagnosisStack.push(diagnosis);
    }

    public static void main(String[] args) {
        push("Diagnosis 1");
        push("Diagnosis 2");
        System.out.println(peek()); // Should print "Diagnosis 2"
        push("Diagnosis 3");
        System.out.println(peek()); // Should print "Diagnosis 3"
        diagnosisStack.pop(); // Remove "Diagnosis 3"
        System.out.println(peek()); // Should print "Diagnosis 2"
        diagnosisStack.clear(); // Clear the stack
        System.out.println(peek()); // Should print ""
    }
}