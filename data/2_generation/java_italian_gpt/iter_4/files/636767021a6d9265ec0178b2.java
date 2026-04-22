import java.util.Stack;

public class StackManipulator {
    private Stack<String> stack;

    public StackManipulator() {
        this.stack = new Stack<>();
    }

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        // Assuming descriptor is in the format of method descriptor (e.g., "(I)V" for a method taking an int and returning void)
        if (descriptor.startsWith("(") && descriptor.contains(")")) {
            int start = descriptor.indexOf('(') + 1;
            int end = descriptor.indexOf(')');
            String args = descriptor.substring(start, end);
            for (int i = args.length() - 1; i >= 0; i--) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the top element for each argument type
                }
            }
        } else {
            // If it's a single type, just pop once
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    public void push(String type) {
        stack.push(type);
    }

    public Stack<String> getStack() {
        return stack;
    }

    public static void main(String[] args) {
        StackManipulator sm = new StackManipulator();
        sm.push("Integer");
        sm.push("String");
        sm.push("Double");

        System.out.println("Stack before pop: " + sm.getStack());
        sm.pop("(I)V"); // Example descriptor for a method taking an int and returning void
        System.out.println("Stack after pop: " + sm.getStack());
    }
}