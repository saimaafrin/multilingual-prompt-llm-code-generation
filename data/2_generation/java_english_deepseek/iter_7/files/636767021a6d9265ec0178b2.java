import org.objectweb.asm.Type;

private void pop(final String descriptor) {
    Type[] types;
    if (descriptor.charAt(0) == '(') {
        // Method descriptor, get argument types
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
                // Pop 1 slot for int, boolean, char, byte, short
                pop(1);
                break;
            case Type.FLOAT:
                // Pop 1 slot for float
                pop(1);
                break;
            case Type.LONG:
                // Pop 2 slots for long
                pop(2);
                break;
            case Type.DOUBLE:
                // Pop 2 slots for double
                pop(2);
                break;
            case Type.ARRAY:
            case Type.OBJECT:
                // Pop 1 slot for array or object reference
                pop(1);
                break;
            case Type.VOID:
                // No action for void
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }
}

private void pop(int slots) {
    // Implementation of popping 'slots' from the output frame stack
    // This is a placeholder for the actual logic to manipulate the stack
    // For example, you might have a stack data structure that you manipulate here
    // stack.pop(slots);
}