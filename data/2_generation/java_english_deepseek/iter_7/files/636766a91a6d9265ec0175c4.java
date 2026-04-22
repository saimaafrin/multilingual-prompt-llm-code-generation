import org.objectweb.asm.Type;

private void pop(final String descriptor) {
    Type[] types;
    if (descriptor.charAt(0) == '(') {
        // It's a method descriptor, so we need to extract the argument types
        types = Type.getArgumentTypes(descriptor);
    } else {
        // It's a single type descriptor
        types = new Type[] { Type.getType(descriptor) };
    }

    // Pop each type from the output frame stack
    for (Type type : types) {
        switch (type.getSort()) {
            case Type.BOOLEAN:
            case Type.BYTE:
            case Type.CHAR:
            case Type.SHORT:
            case Type.INT:
                // Pop an int from the stack
                // Assuming a method popInt() exists to pop an int
                popInt();
                break;
            case Type.FLOAT:
                // Pop a float from the stack
                // Assuming a method popFloat() exists to pop a float
                popFloat();
                break;
            case Type.LONG:
                // Pop a long from the stack
                // Assuming a method popLong() exists to pop a long
                popLong();
                break;
            case Type.DOUBLE:
                // Pop a double from the stack
                // Assuming a method popDouble() exists to pop a double
                popDouble();
                break;
            case Type.ARRAY:
            case Type.OBJECT:
                // Pop a reference from the stack
                // Assuming a method popReference() exists to pop a reference
                popReference();
                break;
            case Type.VOID:
                // No action needed for void
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}

// Placeholder methods for popping specific types from the stack
private void popInt() {
    // Implementation for popping an int from the stack
}

private void popFloat() {
    // Implementation for popping a float from the stack
}

private void popLong() {
    // Implementation for popping a long from the stack
}

private void popDouble() {
    // Implementation for popping a double from the stack
}

private void popReference() {
    // Implementation for popping a reference from the stack
}