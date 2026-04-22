import java.util.Stack;

public class FrameStack {
    private Stack<Object> frameStack = new Stack<>();

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि का वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        // Assuming the descriptor is in the format "L<type>;" for object types or "I" for int, etc.
        // This is a simplified example and may need to be adjusted based on the actual descriptor format.
        if (descriptor.startsWith("L") && descriptor.endsWith(";")) {
            // Pop an object type
            frameStack.pop();
        } else if (descriptor.equals("I")) {
            // Pop an int
            frameStack.pop();
        } else if (descriptor.equals("J")) {
            // Pop a long
            frameStack.pop();
        } else if (descriptor.equals("F")) {
            // Pop a float
            frameStack.pop();
        } else if (descriptor.equals("D")) {
            // Pop a double
            frameStack.pop();
        } else if (descriptor.equals("Z")) {
            // Pop a boolean
            frameStack.pop();
        } else if (descriptor.equals("C")) {
            // Pop a char
            frameStack.pop();
        } else if (descriptor.equals("B")) {
            // Pop a byte
            frameStack.pop();
        } else if (descriptor.equals("S")) {
            // Pop a short
            frameStack.pop();
        } else {
            throw new IllegalArgumentException("Unsupported descriptor: " + descriptor);
        }
    }
}