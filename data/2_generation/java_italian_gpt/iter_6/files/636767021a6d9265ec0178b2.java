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
            String args = descriptor.substring(descriptor.indexOf('(') + 1, descriptor.indexOf(')'));
            int argCount = countArgumentTypes(args);
            for (int i = 0; i < argCount; i++) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the top element from the stack
                }
            }
        } else {
            // If it's a single type descriptor, just pop one element
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    private int countArgumentTypes(String args) {
        int count = 0;
        for (int i = 0; i < args.length(); i++) {
            char c = args.charAt(i);
            if (c == 'L') { // Object type
                count++;
                while (i < args.length() && c != ';') {
                    i++;
                    c = args.charAt(i);
                }
            } else if (c == '[') { // Array type
                while (i < args.length() && args.charAt(i) == '[') {
                    i++;
                }
                if (i < args.length()) {
                    count++;
                }
            } else { // Primitive type
                count++;
            }
        }
        return count;
    }

    public void push(String type) {
        stack.push(type);
    }

    public static void main(String[] args) {
        StackManipulator sm = new StackManipulator();
        sm.push("int");
        sm.push("String");
        sm.push("double");
        
        // Example usage
        sm.pop("(ID)V"); // Should remove 2 types (int and double)
        System.out.println(sm.stack); // Output remaining stack
    }
}