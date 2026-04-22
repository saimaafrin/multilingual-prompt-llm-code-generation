import org.objectweb.asm.Type;

public class StackFrameAnalyzer {
    private int[] outputStack;
    private int outputStackTop;
    
    private void pop(final String descriptor) {
        char firstChar = descriptor.charAt(0);
        
        if (firstChar == '(') {
            // Method descriptor - pop parameter types
            Type[] types = Type.getArgumentTypes(descriptor);
            for (int i = types.length - 1; i >= 0; i--) {
                outputStackTop -= types[i].getSize();
            }
        } else {
            // Type descriptor - pop single type
            if (firstChar == 'J' || firstChar == 'D') {
                // Long or Double takes 2 slots
                outputStackTop -= 2;
            } else {
                // All other types take 1 slot
                outputStackTop--;
            }
        }
        
        // Ensure stack doesn't go negative
        if (outputStackTop < 0) {
            throw new IllegalStateException("Stack underflow");
        }
    }
}