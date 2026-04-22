import java.util.Stack;

public class FrameStackHandler {
    private Stack<Object> frameStack;

    public FrameStackHandler() {
        frameStack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
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
     * @return The number of types to pop.
     */
    private int countTypesInDescriptor(String descriptor) {
        // This is a simplified example. In a real implementation, you would need to parse
        // the descriptor string according to the JVM specification to determine the number of types.
        // For example, a descriptor like "(Ljava/lang/String;I)V" would indicate two types to pop.
        // Here, we assume the descriptor is a simple type name like "Ljava/lang/String;".

        if (descriptor.startsWith("L") && descriptor.endsWith(";")) {
            return 1;
        } else if (descriptor.equals("I") || descriptor.equals("J") || descriptor.equals("F") || descriptor.equals("D")) {
            return 1;
        } else if (descriptor.startsWith("[")) {
            return 1;
        } else {
            throw new IllegalArgumentException("Unsupported descriptor: " + descriptor);
        }
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.frameStack.push("Ljava/lang/String;");
        handler.frameStack.push("I");
        handler.pop("(Ljava/lang/String;I)V");
    }
}