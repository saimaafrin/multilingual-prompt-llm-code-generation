import org.objectweb.asm.Type;
import java.util.Stack;

public class FrameStack {
    private Stack<Type> outputStack;

    public void pop(String descriptor) {
        Type type = Type.getType(descriptor);
        
        if (type.getSort() == Type.METHOD) {
            // For method descriptors, pop argument types
            Type[] argumentTypes = type.getArgumentTypes();
            for (int i = argumentTypes.length - 1; i >= 0; i--) {
                int size = argumentTypes[i].getSize();
                for (int j = 0; j < size; j++) {
                    outputStack.pop();
                }
            }
        } else {
            // For regular type descriptors, pop based on type size
            int size = type.getSize();
            for (int i = 0; i < size; i++) {
                outputStack.pop();
            }
        }
    }
}