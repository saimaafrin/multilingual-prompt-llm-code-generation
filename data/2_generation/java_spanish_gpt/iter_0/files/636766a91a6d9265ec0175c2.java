public class StackFrame {
    private int[] stack;
    private int top;

    public StackFrame(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top < stack.length - 1) {
            stack[++top] = value;
        } else {
            throw new RuntimeException("Stack overflow");
        }
    }

    /** 
     * Extrae un tipo abstracto de la pila de marcos de salida y devuelve su valor.
     * @return el tipo abstracto que ha sido extraído de la pila de marcos de salida.
     */
    private int pop() {
        if (top >= 0) {
            return stack[top--];
        } else {
            throw new RuntimeException("Stack underflow");
        }
    }

    public static void main(String[] args) {
        StackFrame stackFrame = new StackFrame(5);
        stackFrame.push(10);
        stackFrame.push(20);
        System.out.println("Popped value: " + stackFrame.pop()); // Should print 20
        System.out.println("Popped value: " + stackFrame.pop()); // Should print 10
    }
}