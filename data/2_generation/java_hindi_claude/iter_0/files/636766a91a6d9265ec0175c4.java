import org.objectweb.asm.Type;
import java.util.ArrayList;
import java.util.List;

public class FrameStack {
    private List<Type> stack;
    
    public FrameStack() {
        stack = new ArrayList<>();
    }

    public void pop(String descriptor) {
        if (descriptor.startsWith("(")) {
            // Method descriptor - parse argument types
            Type[] argumentTypes = Type.getArgumentTypes(descriptor);
            for (int i = argumentTypes.length - 1; i >= 0; i--) {
                int size = argumentTypes[i].getSize();
                for (int j = 0; j < size; j++) {
                    stack.remove(stack.size() - 1);
                }
            }
        } else {
            // Single type descriptor
            Type type = Type.getType(descriptor);
            int size = type.getSize();
            for (int i = 0; i < size; i++) {
                stack.remove(stack.size() - 1);
            }
        }
    }
}