import java.util.Stack;

public class DiagnosisReference {
    private static Stack<String> referenceStack = new Stack<>();

    public static String peek() {
        if (referenceStack.isEmpty()) {
            return "";
        }
        return referenceStack.peek();
    }

    // Example usage
    public static void main(String[] args) {
        referenceStack.push("Reference1");
        referenceStack.push("Reference2");
        System.out.println(peek()); // Output: Reference2
    }
}