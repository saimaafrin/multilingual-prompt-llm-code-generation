public class StackFrame {
    private int[] stack;
    private int top;

    public StackFrame(int size) {
        stack = new int[size];
        top = -1;
    }

    /** 
     * Extrae un tipo abstracto de la pila de marcos de salida y devuelve su valor.
     * @return el tipo abstracto que ha sido extraído de la pila de marcos de salida.
     */
    private int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = value;
    }

    public static void main(String[] args) {
        StackFrame stackFrame = new StackFrame(5);
        stackFrame.push(10);
        stackFrame.push(20);
        System.out.println("Popped value: " + stackFrame.pop());
    }
}