import org.objectweb.asm.Type;

private void pop(final String descriptor) {
    Type type = Type.getType(descriptor);
    if (type.getSort() == Type.METHOD) {
        Type[] argumentTypes = type.getArgumentTypes();
        for (Type argType : argumentTypes) {
            // Pop the argument types from the output frame stack
            // Assuming a stack-like structure is used to represent the frame
            // This is a placeholder for the actual stack manipulation logic
            // stack.pop();
        }
    } else {
        // Pop the single type from the output frame stack
        // stack.pop();
    }
}