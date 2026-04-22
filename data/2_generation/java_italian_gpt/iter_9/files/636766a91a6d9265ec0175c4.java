import java.util.Stack;

public class DescriptorPopper {
    private Stack<String> stack;

    public DescriptorPopper() {
        this.stack = new Stack<>();
    }

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        // Assuming descriptor is in the format of method descriptor (e.g., "(I)V" for a method that takes an int and returns void)
        if (descriptor.startsWith("(") && descriptor.contains(")")) {
            int start = descriptor.indexOf('(') + 1;
            int end = descriptor.indexOf(')');
            String args = descriptor.substring(start, end);
            for (char arg : args.toCharArray()) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the corresponding argument type from the stack
                }
            }
        } else {
            // If it's a single type descriptor, just pop it from the stack
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    // Method to push types onto the stack for testing purposes
    public void push(String type) {
        stack.push(type);
    }

    // Method to view the current stack for testing purposes
    public Stack<String> getStack() {
        return stack;
    }

    public static void main(String[] args) {
        DescriptorPopper popper = new DescriptorPopper();
        popper.push("I"); // Push an int type
        popper.push("Ljava/lang/String;"); // Push a String type
        System.out.println("Stack before pop: " + popper.getStack());
        popper.pop("(I)V"); // Pop types according to the descriptor
        System.out.println("Stack after pop: " + popper.getStack());
    }
}