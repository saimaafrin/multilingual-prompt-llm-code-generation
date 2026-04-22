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
        // Assuming the descriptor contains the number of elements to pop
        // For example, "I" for int, "D" for double, etc.
        int count = descriptor.length();
        for (int i = 0; i < count; i++) {
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("Frame stack is empty.");
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.frameStack.push(1);
        handler.frameStack.push(2.0);
        handler.frameStack.push("Hello");

        handler.pop("IDLjava/lang/String;"); // Pops 3 elements: int, double, and String
    }
}