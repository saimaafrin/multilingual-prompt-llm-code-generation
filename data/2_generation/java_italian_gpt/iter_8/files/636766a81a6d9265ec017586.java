public class StackFrame {
    private final Stack<String> stack;

    public StackFrame() {
        this.stack = new Stack<>();
    }

    /** 
     * Rimuove il numero specificato di tipi astratti dallo stack del frame di output.
     * @param elements il numero di tipi astratti che devono essere rimossi.
     */
    private void pop(final int elements) {
        for (int i = 0; i < elements; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                break; // Stop if the stack is empty
            }
        }
    }

    // Method to push elements onto the stack for testing purposes
    public void push(String element) {
        stack.push(element);
    }

    // Method to view the current stack for testing purposes
    public Stack<String> getStack() {
        return stack;
    }

    public static void main(String[] args) {
        StackFrame frame = new StackFrame();
        frame.push("Type1");
        frame.push("Type2");
        frame.push("Type3");

        System.out.println("Stack before pop: " + frame.getStack());
        frame.pop(2);
        System.out.println("Stack after popping 2 elements: " + frame.getStack());
    }
}