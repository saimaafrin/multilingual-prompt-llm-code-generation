import java.util.Stack;

public class AbstractTypeHandler {
    private Stack<Object> outputFrameStack;

    public AbstractTypeHandler() {
        this.outputFrameStack = new Stack<>();
    }

    /**
     * दिए गए संख्या के अमूर्त प्रकारों को आउटपुट फ्रेम स्टैक से पॉप करता है।
     * @param elements वह संख्या है जो अमूर्त प्रकारों को पॉप करना है।
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Number of elements to pop cannot be negative.");
        }
        if (outputFrameStack.size() < elements) {
            throw new IllegalStateException("Not enough elements in the stack to pop.");
        }
        for (int i = 0; i < elements; i++) {
            outputFrameStack.pop();
        }
    }
}