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

    public void push(Object item) {
        stack.push(item);
    }

    public Object peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}