public class StackFrame {
    private final Stack<Object> stack;

    public StackFrame() {
        this.stack = new Stack<>();
    }

    /** 
     * Rimuove il numero specificato di tipi astratti dallo stack del frame di output.
     * @param elements il numero di tipi astratti che devono essere rimossi.
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Number of elements to pop must be non-negative.");
        }
        for (int i = 0; i < elements; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                break; // Stop if the stack is empty
            }
        }
    }

    // Additional methods to push and display stack for testing purposes
    public void push(Object item) {
        stack.push(item);
    }

    public void displayStack() {
        System.out.println(stack);
    }

    public static void main(String[] args) {
        StackFrame frame = new StackFrame();
        frame.push("Type1");
        frame.push("Type2");
        frame.push("Type3");
        frame.displayStack(); // Output: [Type1, Type2, Type3]

        frame.pop(2);
        frame.displayStack(); // Output: [Type1]
        
        frame.pop(1);
        frame.displayStack(); // Output: []
        
        frame.pop(1); // No effect, stack is already empty
        frame.displayStack(); // Output: []
    }
}