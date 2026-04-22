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
        if (elements <= 0) {
            throw new IllegalArgumentException("Number of elements to pop must be greater than zero.");
        }
        for (int i = 0; i < elements; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                throw new EmptyStackException();
            }
        }
    }

    public void push(String element) {
        stack.push(element);
    }

    public String peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackFrame frame = new StackFrame();
        frame.push("Type1");
        frame.push("Type2");
        frame.push("Type3");

        System.out.println("Stack before pop: " + frame.stack);
        frame.pop(2);
        System.out.println("Stack after popping 2 elements: " + frame.stack);
    }
}