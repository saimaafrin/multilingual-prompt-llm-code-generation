import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack;

    public FrameStack() {
        this.stack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि का वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        // Assuming descriptor is a string representation of the types to pop
        String[] types = descriptor.split(",");
        for (String type : types) {
            if (!stack.isEmpty()) {
                Object poppedValue = stack.pop();
                // Here you can add logic to check if the poppedValue matches the type
                // For simplicity, we are just printing the popped value
                System.out.println("Popped: " + poppedValue + " for type: " + type);
            } else {
                System.out.println("Stack is empty, cannot pop more values.");
                break;
            }
        }
    }

    public void push(Object value) {
        stack.push(value);
    }

    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.push("StringValue");
        frameStack.push(42);
        frameStack.push(3.14);

        frameStack.pop("String,Integer,Double");
    }
}