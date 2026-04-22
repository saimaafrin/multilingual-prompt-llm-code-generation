import java.util.Stack;

public class MethodFrameHandler {
    private Stack<Object> operandStack;

    /**
     * Extrae tantos tipos abstractos de la pila de marcos de salida como lo describe el descriptor dado.
     * @param descriptor un tipo o descriptor de método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        String desc = descriptor;
        
        // Si es un descriptor de método, extraer solo los argumentos
        if (descriptor.charAt(0) == '(') {
            desc = descriptor.substring(1, descriptor.indexOf(')'));
        }

        int index = 0;
        while (index < desc.length()) {
            char c = desc.charAt(index);
            
            switch (c) {
                case 'B': // byte
                case 'C': // char
                case 'I': // int
                case 'S': // short
                case 'Z': // boolean
                case 'F': // float
                    operandStack.pop();
                    index++;
                    break;
                    
                case 'J': // long
                case 'D': // double
                    operandStack.pop();
                    index++;
                    break;
                    
                case 'L': // Object reference
                    operandStack.pop();
                    index = desc.indexOf(';', index) + 1;
                    break;
                    
                case '[': // Array
                    int dimensions = 0;
                    while (desc.charAt(index) == '[') {
                        dimensions++;
                        index++;
                    }
                    if (desc.charAt(index) == 'L') {
                        index = desc.indexOf(';', index) + 1;
                    } else {
                        index++;
                    }
                    operandStack.pop();
                    break;
                    
                default:
                    throw new IllegalArgumentException("Invalid descriptor: " + descriptor);
            }
        }
    }
}