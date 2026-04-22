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
        // Assuming descriptor is a string representation of the type to pop
        // For simplicity, we will just print the descriptor and pop elements
        System.out.println("Popping elements for descriptor: " + descriptor);
        
        // Example logic to pop elements based on descriptor
        while (!stack.isEmpty()) {
            Object element = stack.pop();
            // Here we would check if the element matches the descriptor
            // For demonstration, we will just print the popped element
            System.out.println("Popped element: " + element);
        }
    }

    public void push(Object item) {
        stack.push(item);
    }

    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.push("First");
        frameStack.push("Second");
        frameStack.push("Third");
        
        frameStack.pop("String"); // Example call to pop method
    }
}