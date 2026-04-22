import org.objectweb.asm.Type;
import java.util.ArrayList;
import java.util.List;

public class FrameStack {
    private List<Type> stack;
    
    public FrameStack() {
        stack = new ArrayList<>();
    }

    public void pop(String descriptor) {
        Type type = Type.getType(descriptor);
        
        if (type.getSort() == Type.METHOD) {
            // For method descriptors, pop argument types
            Type[] argumentTypes = type.getArgumentTypes();
            for (int i = argumentTypes.length - 1; i >= 0; i--) {
                int size = argumentTypes[i].getSize();
                for (int j = 0; j < size; j++) {
                    stack.remove(stack.size() - 1);
                }
            }
        } else {
            // For regular type descriptors, pop the type size
            int size = type.getSize();
            for (int i = 0; i < size; i++) {
                stack.remove(stack.size() - 1);
            }
        }
    }
}