import java.util.Stack;

public class FrameStack {
    private Stack<Object> operandStack;

    private void pop(final String descriptor) {
        int index = 0;
        
        // Process array types
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            
            switch (c) {
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
                    
                case '(':
                    // Skip opening parenthesis for method descriptor
                    index++;
                    break;
                    
                case ')':
                    // End of method arguments
                    return;
                    
                default:
                    // Handle primitive types
                    switch (c) {
                        case 'D':
                        case 'J':
                            // Double and long take two stack slots
                            operandStack.pop();
                            operandStack.pop();
                            break;
                        case 'F':
                        case 'I':
                        case 'B':
                        case 'C':
                        case 'S':
                        case 'Z':
                            // Other primitives take one slot
                            operandStack.pop();
                            break;
                    }
                    index++;
            }
        }
    }
}