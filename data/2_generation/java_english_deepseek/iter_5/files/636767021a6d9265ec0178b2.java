import org.objectweb.asm.Type;

private void pop(final String descriptor) {
    Type[] types;
    if (descriptor.charAt(0) == '(') {
        // Method descriptor: extract argument types
        types = Type.getArgumentTypes(descriptor);
    } else {
        // Single type descriptor
        types = new Type[] { Type.getType(descriptor) };
    }

    for (Type type : types) {
        switch (type.getSort()) {
            case Type.BOOLEAN:
            case Type.CHAR:
            case Type.BYTE:
            case Type.SHORT:
            case Type.INT:
                // Pop one slot for primitive types
                // Assuming outputFrameStack is a stack-like structure
                outputFrameStack.pop();
                break;
            case Type.LONG:
            case Type.DOUBLE:
                // Pop two slots for long and double
                outputFrameStack.pop();
                outputFrameStack.pop();
                break;
            case Type.ARRAY:
            case Type.OBJECT:
                // Pop one slot for reference types
                outputFrameStack.pop();
                break;
            case Type.VOID:
                // No action needed for void
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }
}