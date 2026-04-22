import org.objectweb.asm.Type;

public class StackFrameAnalyzer {
    private Stack<Type> outputStack;

    private void pop(final String descriptor) {
        if (descriptor.charAt(0) == '(') {
            // Method descriptor - pop argument types
            Type[] argumentTypes = Type.getArgumentTypes(descriptor);
            for (int i = argumentTypes.length - 1; i >= 0; i--) {
                outputStack.pop();
            }
        } else {
            // Type descriptor - pop single type
            Type type = Type.getType(descriptor);
            if (type.getSize() == 2) {
                // Double or long take up 2 slots
                outputStack.pop();
                outputStack.pop();
            } else {
                outputStack.pop();
            }
        }
    }
}