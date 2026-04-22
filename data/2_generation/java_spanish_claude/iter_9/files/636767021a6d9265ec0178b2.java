import java.util.Stack;

public class MethodFrameHandler {
    private Stack<Object> operandStack;

    private void pop(final String descriptor) {
        int index = 0;
        
        // Process array types
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            
            switch (c) {
                case '(':
                    // Skip opening parenthesis for method descriptors
                    index++;
                    continue;
                case ')':
                    // End of method arguments
                    return;
                case '[':
                    // Skip array dimensions
                    while (descriptor.charAt(index) == '[') {
                        index++;
                    }
                    // Pop array reference
                    operandStack.pop();
                    index++;
                    break;
                case 'L':
                    // Skip to end of object type
                    while (descriptor.charAt(index) != ';') {
                        index++;
                    }
                    // Pop object reference
                    operandStack.pop();
                    index++;
                    break;
                case 'J':
                case 'D':
                    // Pop long/double (takes 2 slots)
                    operandStack.pop();
                    operandStack.pop();
                    index++;
                    break;
                case 'I':
                case 'F':
                case 'B':
                case 'C':
                case 'S':
                case 'Z':
                    // Pop int/float/byte/char/short/boolean
                    operandStack.pop();
                    index++;
                    break;
                default:
                    index++;
            }
        }
    }
}