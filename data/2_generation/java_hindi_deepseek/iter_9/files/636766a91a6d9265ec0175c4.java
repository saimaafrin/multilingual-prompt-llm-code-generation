import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack = new Stack<>();

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        // Parse the descriptor to determine how many types to pop
        int count = countTypesInDescriptor(descriptor);
        
        // Pop the required number of types from the stack
        for (int i = 0; i < count; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                throw new IllegalStateException("Stack is empty, cannot pop more elements.");
            }
        }
    }

    /**
     * Helper method to count the number of types in the descriptor.
     * @param descriptor The descriptor string.
     * @return The number of types to pop.
     */
    private int countTypesInDescriptor(String descriptor) {
        // This is a simplified example. In a real implementation, you would need to parse
        // the descriptor according to the JVM specification to determine the number of types.
        // For example, a descriptor like "(Ljava/lang/String;I)V" would indicate two types: String and int.
        
        // For simplicity, let's assume the descriptor is a comma-separated list of types.
        return descriptor.split(",").length;
    }

    // Example usage
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.stack.push("Type1");
        frameStack.stack.push("Type2");
        frameStack.stack.push("Type3");

        frameStack.pop("Type1,Type2"); // Pops two types from the stack

        System.out.println(frameStack.stack); // Output: [Type3]
    }
}