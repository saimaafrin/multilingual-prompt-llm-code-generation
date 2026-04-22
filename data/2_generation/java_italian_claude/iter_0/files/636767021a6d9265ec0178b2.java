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
                    // End of arguments for method descriptor
                    return;
                    
                case 'B':
                case 'C': 
                case 'I':
                case 'S':
                case 'Z':
                case 'F':
                    // Pop single slot types
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    index++;
                    break;
                    
                case 'D':
                case 'J':
                    // Pop double slot types
                    if (!stack.isEmpty()) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                    index++;
                    break;
                    
                case 'L':
                    // Skip class descriptor until semicolon
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    index = descriptor.indexOf(';', index) + 1;
                    break;
                    
                case '[':
                    // Skip array dimension
                    index++;
                    break;
                    
                default:
                    // Invalid descriptor character
                    throw new IllegalArgumentException("Invalid descriptor: " + descriptor);
            }
        }
    }
}