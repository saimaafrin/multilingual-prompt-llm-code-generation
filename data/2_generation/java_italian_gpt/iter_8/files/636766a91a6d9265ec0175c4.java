import java.util.Stack;

public class DescriptorStack {

    private Stack<String> stack;

    public DescriptorStack() {
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
            String args = descriptor.substring(descriptor.indexOf('(') + 1, descriptor.indexOf(')'));
            String[] argTypes = args.split(",");
            for (String argType : argTypes) {
                // Remove the argument type from the stack if it exists
                if (!argType.isEmpty() && stack.contains(argType)) {
                    stack.remove(argType);
                }
            }
        } else {
            // If it's a single type, remove it directly
            stack.remove(descriptor);
        }
    }

    // Method to push types onto the stack for testing purposes
    public void push(String type) {
        stack.push(type);
    }

    // Method to display the current stack for testing purposes
    public void displayStack() {
        System.out.println(stack);
    }

    public static void main(String[] args) {
        DescriptorStack ds = new DescriptorStack();
        ds.push("I");
        ds.push("J");
        ds.push("V");
        ds.displayStack(); // Output: [I, J, V]

        ds.pop("(I)V");
        ds.displayStack(); // Output: [J]
    }
}