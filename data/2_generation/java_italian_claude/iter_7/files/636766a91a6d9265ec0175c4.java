import java.util.Stack;

public class FrameStack {
    private Stack<String> stack;

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        int index = 0;
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            
            switch (c) {
                case '(':
                    // Skip opening parenthesis for method descriptor
                    index++;
                    continue;
                case ')':
                    // End of method arguments
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
                    // Skip until semicolon for object types
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    index = descriptor.indexOf(';', index) + 1;
                    break;
                case '[':
                    // Skip array dimensions
                    while (index < descriptor.length() && descriptor.charAt(index) == '[') {
                        index++;
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    if (index < descriptor.length() && descriptor.charAt(index) == 'L') {
                        index = descriptor.indexOf(';', index) + 1;
                    } else {
                        index++;
                    }
                    break;
                default:
                    index++;
            }
        }
    }
}