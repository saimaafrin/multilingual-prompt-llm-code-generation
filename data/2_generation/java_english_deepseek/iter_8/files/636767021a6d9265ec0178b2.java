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

    // Pop each type from the output frame stack
    for (Type type : types) {
        switch (type.getSort()) {
            case Type.BOOLEAN:
            case Type.BYTE:
            case Type.CHAR:
            case Type.SHORT:
            case Type.INT:
                // Pop int
                // Assuming a method `popInt()` exists to pop an int from the stack
                popInt();
                break;
            case Type.FLOAT:
                // Pop float
                // Assuming a method `popFloat()` exists to pop a float from the stack
                popFloat();
                break;
            case Type.LONG:
                // Pop long (takes two slots)
                // Assuming a method `popLong()` exists to pop a long from the stack
                popLong();
                break;
            case Type.DOUBLE:
                // Pop double (takes two slots)
                // Assuming a method `popDouble()` exists to pop a double from the stack
                popDouble();
                break;
            case Type.ARRAY:
            case Type.OBJECT:
                // Pop reference
                // Assuming a method `popReference()` exists to pop a reference from the stack
                popReference();
                break;
            case Type.VOID:
                // No action needed for void
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }
}

// Placeholder methods for popping from the stack
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