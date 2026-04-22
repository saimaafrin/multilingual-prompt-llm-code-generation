import java.util.Stack;

public class OutputFrameStack {
    private Stack<Integer> stack;

    public OutputFrameStack() {
        stack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से एक अमूर्त प्रकार को पॉप करता है और इसका मान लौटाता है।
     * @return वह अमूर्त प्रकार जो आउटपुट फ्रेम स्टैक से पॉप किया गया है।
     */
    private int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.pop();
    }

    public void push(int value) {
        stack.push(value);
    }

    public static void main(String[] args) {
        OutputFrameStack outputFrameStack = new OutputFrameStack();
        outputFrameStack.push(10);
        outputFrameStack.push(20);
        System.out.println(outputFrameStack.pop()); // Outputs: 20
        System.out.println(outputFrameStack.pop()); // Outputs: 10
    }
}