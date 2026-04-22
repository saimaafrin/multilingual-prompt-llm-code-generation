import java.util.Stack;

public class FrameStack {
    private Stack<Integer> outputFrameStack;

    public FrameStack() {
        outputFrameStack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से एक अमूर्त प्रकार को पॉप करता है और इसका मान लौटाता है।
     * @return वह अमूर्त प्रकार जो आउटपुट फ्रेम स्टैक से पॉप किया गया है।
     */
    private int pop() {
        if (outputFrameStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return outputFrameStack.pop();
    }
}