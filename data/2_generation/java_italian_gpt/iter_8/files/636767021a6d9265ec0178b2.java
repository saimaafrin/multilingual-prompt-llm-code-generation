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
        // Assuming descriptor is in the format of method descriptor (e.g., "(I)V" for a method that takes an int and returns void)
        if (descriptor.startsWith("(") && descriptor.contains(")")) {
            // Extract argument types from the descriptor
            int start = descriptor.indexOf('(') + 1;
            int end = descriptor.indexOf(')');
            String args = descriptor.substring(start, end);
            
            // Remove argument types from the stack
            for (char arg : args.toCharArray()) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the top element for each argument type
                }
            }
        } else {
            // If it's a single type, just pop it from the stack
            if (!stack.isEmpty()) {
                stack.pop();
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
        StackManipulator sm = new StackManipulator();
        sm.push("Integer");
        sm.push("String");
        sm.push("Double");

        System.out.println("Stack before pop: " + sm.getStack());
        sm.pop("(I)V"); // Example descriptor for a method taking an int and returning void
        System.out.println("Stack after pop: " + sm.getStack());
    }
}