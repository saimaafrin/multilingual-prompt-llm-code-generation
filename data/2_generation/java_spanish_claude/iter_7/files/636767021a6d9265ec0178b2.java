import java.util.Stack;

public class FrameStack {
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
                    
                case 'B': // byte
                case 'C': // char 
                case 'I': // int
                case 'Z': // boolean
                case 'S': // short
                case 'F': // float
                    operandStack.pop();
                    index++;
                    break;
                    
                case 'J': // long
                case 'D': // double
                    operandStack.pop();
                    operandStack.pop(); // Pop twice for long/double
                    index++;
                    break;
                    
                case 'L':
                    // Skip until semicolon for object types
                    while (descriptor.charAt(index) != ';') {
                        index++;
                    }
                    operandStack.pop();
                    index++;
                    break;
                    
                case '[':
                    // Array type - continue to element type
                    while (descriptor.charAt(index) == '[') {
                        index++;
                    }
                    if (descriptor.charAt(index) == 'L') {
                        while (descriptor.charAt(index) != ';') {
                            index++;
                        }
                    }
                    operandStack.pop();
                    index++;
                    break;
                    
                default:
                    throw new IllegalArgumentException("Invalid descriptor: " + descriptor);
            }
        }
    }
}