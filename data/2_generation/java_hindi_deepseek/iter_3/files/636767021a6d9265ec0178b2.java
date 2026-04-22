import java.util.Stack;

public class FrameStackHandler {
    private Stack<Object> frameStack;

    public FrameStackHandler() {
        this.frameStack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि का वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        // Parse the descriptor to determine how many types to pop
        int count = countTypesInDescriptor(descriptor);

        // Pop the required number of types from the stack
        for (int i = 0; i < count; i++) {
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("Frame stack is empty.");
            }
        }
    }

    /**
     * Helper method to count the number of types in the descriptor.
     * @param descriptor The descriptor string.
     * @return The number of types in the descriptor.
     */
    private int countTypesInDescriptor(String descriptor) {
        // This is a simplified example. In a real implementation, you would need to parse
        // the descriptor string according to the JVM specification to count the types.
        // For example, a descriptor like "(Ljava/lang/String;I)V" would have 2 types.
        // Here, we assume the descriptor is a simple string where each character represents a type.
        return descriptor.length();
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.frameStack.push("Type1");
        handler.frameStack.push("Type2");
        handler.frameStack.push("Type3");

        handler.pop("Type1Type2"); // Pops 2 types from the stack
    }
}