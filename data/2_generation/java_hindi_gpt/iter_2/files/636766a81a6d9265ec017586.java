import java.util.Stack;

public class AbstractTypeStack {
    private Stack<Object> stack;

    public AbstractTypeStack() {
        stack = new Stack<>();
    }

    /**
     * दिए गए संख्या के अमूर्त प्रकारों को आउटपुट फ्रेम स्टैक से पॉप करता है।
     * @param elements वह संख्या है जो अमूर्त प्रकारों को पॉप करना है।
     */
    private void pop(final int elements) {
        for (int i = 0; i < elements; i++) {
            if (!stack.isEmpty()) {
                Object poppedElement = stack.pop();
                System.out.println("Popped: " + poppedElement);
            } else {
                System.out.println("Stack is empty, cannot pop more elements.");
                break;
            }
        }
    }

    public void push(Object element) {
        stack.push(element);
    }

    public static void main(String[] args) {
        AbstractTypeStack abstractTypeStack = new AbstractTypeStack();
        abstractTypeStack.push("Element 1");
        abstractTypeStack.push("Element 2");
        abstractTypeStack.push("Element 3");

        abstractTypeStack.pop(2); // Popping 2 elements
        abstractTypeStack.pop(2); // Attempting to pop more elements than available
    }
}