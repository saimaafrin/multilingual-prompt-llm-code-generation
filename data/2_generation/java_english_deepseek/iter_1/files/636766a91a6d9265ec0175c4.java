import org.objectweb.asm.Type;

private void pop(final String descriptor) {
    Type[] types;
    if (descriptor.charAt(0) == '(') {
        // It's a method descriptor, get argument types
        types = Type.getArgumentTypes(descriptor);
    } else {
        // It's a type descriptor, get the single type
        types = new Type[] { Type.getType(descriptor) };
    }

    for (Type type : types) {
        switch (type.getSort()) {
            case Type.BOOLEAN:
            case Type.CHAR:
            case Type.BYTE:
            case Type.SHORT:
            case Type.INT:
            case Type.FLOAT:
            case Type.ARRAY:
            case Type.OBJECT:
                // Pop one slot from the stack
                // Assuming a method `pop()` exists to pop one slot
                pop();
                break;
            case Type.LONG:
            case Type.DOUBLE:
                // Pop two slots from the stack
                pop();
                pop();
                break;
            case Type.VOID:
                // No action needed for void
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}

// Assuming a method `pop()` exists to pop one slot from the stack
private void pop() {
    // Implementation of popping one slot from the stack
    // This is a placeholder and should be implemented based on the actual stack structure
}