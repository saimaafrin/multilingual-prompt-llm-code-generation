import java.util.Stack;

public class FrameStackHandler {
    private Stack<Object> frameStack;

    public FrameStackHandler() {
        this.frameStack = new Stack<>();
    }

    /**
     * Extrae tantos tipos abstractos de la "frame stack" de salida como lo describe el descriptor dado.
     * @param descriptor un descriptor de tipo o método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        int index = 0;
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            switch (c) {
                case '(':
                    // Skip opening parenthesis for method descriptors
                    index++;
                    continue;
                case ')':
                    // End of method parameters
                    return;
                case 'B':
                case 'C': 
                case 'I':
                case 'S':
                case 'Z':
                case 'F':
                    // Pop single-slot types
                    frameStack.pop();
                    index++;
                    break;
                case 'J':
                case 'D':
                    // Pop double-slot types
                    frameStack.pop();
                    frameStack.pop();
                    index++;
                    break;
                case 'L':
                    // Pop reference type
                    frameStack.pop();
                    // Skip to semicolon
                    index = descriptor.indexOf(';', index) + 1;
                    break;
                case '[':
                    // Array type - continue to base type
                    while (descriptor.charAt(index) == '[') {
                        index++;
                    }
                    if (descriptor.charAt(index) == 'L') {
                        index = descriptor.indexOf(';', index) + 1;
                    } else {
                        index++;
                    }
                    frameStack.pop();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid descriptor character: " + c);
            }
        }
    }
}