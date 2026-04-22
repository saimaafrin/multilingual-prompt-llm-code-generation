import java.util.Stack;

public class FrameStackHandler {
    private Stack<String> frameStack;

    public FrameStackHandler() {
        frameStack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि का वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            throw new IllegalArgumentException("Descriptor cannot be null or empty");
        }

        // Assuming the descriptor contains the number of types to pop
        // For example, "(Ljava/lang/String;I)V" would indicate two types to pop
        int numTypesToPop = countTypesInDescriptor(descriptor);

        for (int i = 0; i < numTypesToPop; i++) {
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("Frame stack is empty");
            }
        }
    }

    /**
     * Counts the number of types in the descriptor.
     * @param descriptor The descriptor string.
     * @return The number of types in the descriptor.
     */
    private int countTypesInDescriptor(String descriptor) {
        int count = 0;
        int index = 0;
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            if (c == 'L') {
                // Skip until ';' for object types
                index = descriptor.indexOf(';', index) + 1;
                count++;
            } else if (c == '[') {
                // Skip array type
                index++;
            } else if (c == 'V' || c == 'I' || c == 'J' || c == 'F' || c == 'D' || c == 'Z' || c == 'B' || c == 'C' || c == 'S') {
                // Primitive types
                index++;
                count++;
            } else {
                // Unknown type, skip
                index++;
            }
        }
        return count;
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.frameStack.push("Ljava/lang/String;");
        handler.frameStack.push("I");
        handler.pop("(Ljava/lang/String;I)V");
        System.out.println(handler.frameStack); // Should print an empty stack
    }
}