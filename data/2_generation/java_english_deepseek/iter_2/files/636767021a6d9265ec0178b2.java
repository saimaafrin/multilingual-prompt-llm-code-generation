import org.objectweb.asm.Type;

private void pop(final String descriptor) {
    Type type = Type.getType(descriptor);
    if (type.getSort() == Type.METHOD) {
        Type[] argumentTypes = type.getArgumentTypes();
        for (Type argType : argumentTypes) {
            // Pop the argument types from the output frame stack
            // Assuming a method popFrame() exists to pop a single type
            popFrame(argType);
        }
    } else {
        // Pop a single type from the output frame stack
        popFrame(type);
    }
}

// Assuming this method exists to pop a single type from the frame stack
private void popFrame(Type type) {
    // Implementation of popping a single type from the frame stack
    // This is a placeholder and should be implemented based on the actual frame stack structure
    System.out.println("Popping type: " + type.getClassName());
}