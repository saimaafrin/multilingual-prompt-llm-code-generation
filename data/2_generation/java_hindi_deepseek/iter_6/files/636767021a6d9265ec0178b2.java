import java.util.Stack;

public class FrameStackHandler {
    private Stack<Object> frameStack;

    public FrameStackHandler() {
        frameStack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि का वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        // Assuming the descriptor is in the format "L<type>;" for object types or "I" for int, etc.
        // This is a simplified example, actual implementation may vary based on descriptor format.
        if (descriptor.startsWith("L") && descriptor.endsWith(";")) {
            // Pop an object type
            frameStack.pop();
        } else if (descriptor.equals("I")) {
            // Pop an int type
            frameStack.pop();
        } else if (descriptor.equals("J")) {
            // Pop a long type
            frameStack.pop();
        } else if (descriptor.equals("F")) {
            // Pop a float type
            frameStack.pop();
        } else if (descriptor.equals("D")) {
            // Pop a double type
            frameStack.pop();
        } else if (descriptor.equals("Z")) {
            // Pop a boolean type
            frameStack.pop();
        } else if (descriptor.equals("C")) {
            // Pop a char type
            frameStack.pop();
        } else if (descriptor.equals("B")) {
            // Pop a byte type
            frameStack.pop();
        } else if (descriptor.equals("S")) {
            // Pop a short type
            frameStack.pop();
        } else {
            throw new IllegalArgumentException("Unsupported descriptor: " + descriptor);
        }
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.frameStack.push(10); // Push an int
        handler.frameStack.push(20L); // Push a long
        handler.pop("I"); // Pop an int
        handler.pop("J"); // Pop a long
    }
}