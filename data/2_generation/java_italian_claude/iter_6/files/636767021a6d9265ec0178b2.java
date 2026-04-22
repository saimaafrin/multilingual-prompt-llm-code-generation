import java.util.Stack;

public class FrameStack {
    private Stack<String> stack;

    public FrameStack() {
        stack = new Stack<>();
    }

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        int index = 0;
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            switch (c) {
                case '(':
                    // Skip opening parenthesis for method descriptor
                    index++;
                    break;
                case ')':
                    // Stop at closing parenthesis
                    return;
                case '[':
                    // Skip array dimensions
                    while (descriptor.charAt(index) == '[') {
                        index++;
                    }
                    // Pop array reference
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    index++;
                    break;
                case 'L':
                    // Skip to end of object type
                    while (descriptor.charAt(index) != ';') {
                        index++;
                    }
                    // Pop object reference
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    index++;
                    break;
                case 'D':
                case 'J':
                    // Pop double/long (takes 2 slots)
                    if (!stack.isEmpty()) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                    index++;
                    break;
                default:
                    // Pop single-slot primitive
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    index++;
                    break;
            }
        }
    }
}