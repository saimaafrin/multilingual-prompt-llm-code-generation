import java.util.Stack;

public class FrameStackHandler {
    private Stack<Object> frameStack;

    public FrameStackHandler() {
        this.frameStack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        // Assuming the descriptor is in the format "L<type>;" for object types or "I", "J", etc. for primitive types
        // This is a simplified example; actual implementation may need to handle more complex cases
        int count = countTypesInDescriptor(descriptor);
        for (int i = 0; i < count; i++) {
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("Frame stack is empty.");
            }
        }
    }

    private int countTypesInDescriptor(String descriptor) {
        // This is a placeholder method to count the number of types in the descriptor
        // For example, "Ljava/lang/String;" would count as 1, "II" would count as 2, etc.
        // Actual implementation would need to parse the descriptor properly
        return descriptor.length(); // Simplified for example purposes
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.frameStack.push("String");
        handler.frameStack.push(123);
        handler.pop("Ljava/lang/String;I");
        System.out.println(handler.frameStack); // Should be empty after popping
    }
}