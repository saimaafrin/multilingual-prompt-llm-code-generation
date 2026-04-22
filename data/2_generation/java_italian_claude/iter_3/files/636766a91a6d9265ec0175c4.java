import java.util.Stack;

public class FrameHandler {
    private Stack<String> outputStack;

    public FrameHandler() {
        this.outputStack = new Stack<>();
    }

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
                    // Stop at closing parenthesis
                    return;
                case 'B':
                case 'C':
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                case 'S':
                case 'Z':
                    // Pop primitive types
                    if (!outputStack.isEmpty()) {
                        outputStack.pop();
                    }
                    if (c == 'D' || c == 'J') {
                        // Double and Long take two stack slots
                        if (!outputStack.isEmpty()) {
                            outputStack.pop();
                        }
                    }
                    index++;
                    break;
                case 'L':
                    // Pop object reference type
                    if (!outputStack.isEmpty()) {
                        outputStack.pop();
                    }
                    // Skip to semicolon
                    index = descriptor.indexOf(';', index) + 1;
                    break;
                case '[':
                    // Skip array dimension
                    index++;
                    break;
                default:
                    index++;
                    break;
            }
        }
    }
}