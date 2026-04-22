import org.objectweb.asm.Type;

public class StackFrameAnalyzer {
    private Stack<AbstractType> outputStack;

    private void pop(final String descriptor) {
        if (descriptor.charAt(0) == '(') {
            // Method descriptor - pop argument types
            Type[] argumentTypes = Type.getArgumentTypes(descriptor);
            for (int i = argumentTypes.length - 1; i >= 0; i--) {
                pop(argumentTypes[i].getDescriptor());
            }
        } else {
            // Type descriptor - pop single type
            char firstChar = descriptor.charAt(0);
            if (firstChar == 'J' || firstChar == 'D') {
                // Long and Double take up 2 slots
                outputStack.pop();
                outputStack.pop();
            } else if (firstChar != 'V') {
                // Void takes no slots, everything else takes 1
                outputStack.pop();
            }
        }
    }
}