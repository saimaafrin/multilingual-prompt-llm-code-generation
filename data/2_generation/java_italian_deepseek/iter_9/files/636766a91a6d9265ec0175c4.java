import java.util.Stack;

public class FrameStack {
    private Stack<String> outputFrameStack = new Stack<>();

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        if (descriptor.startsWith("(")) {
            // It's a method descriptor, remove argument types
            int endOfArgs = descriptor.indexOf(')');
            if (endOfArgs == -1) {
                return; // Invalid descriptor
            }

            String argsDescriptor = descriptor.substring(1, endOfArgs);
            int index = 0;
            while (index < argsDescriptor.length()) {
                char c = argsDescriptor.charAt(index);
                if (c == 'L') {
                    // Object type, skip until ';'
                    int end = argsDescriptor.indexOf(';', index);
                    if (end == -1) {
                        return; // Invalid descriptor
                    }
                    index = end + 1;
                } else if (c == '[') {
                    // Array type, skip the '['
                    index++;
                } else {
                    // Primitive type, just skip the character
                    index++;
                }
                // Pop the type from the stack
                if (!outputFrameStack.isEmpty()) {
                    outputFrameStack.pop();
                }
            }
        } else {
            // It's a single type descriptor, pop it from the stack
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            }
        }
    }
}