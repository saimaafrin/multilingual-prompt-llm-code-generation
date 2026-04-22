import org.objectweb.asm.Type;

private void pop(final String descriptor) {
    Type[] types;
    if (descriptor.charAt(0) == '(') {
        // It's a method descriptor, get argument types
        types = Type.getArgumentTypes(descriptor);
    } else {
        // It's a single type descriptor
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
                throw new IllegalArgumentException("Unknown type sort: " + type.getSort());
        }
    }
}

private void pop(int slots) {
    // Implementation of popping 'slots' number of slots from the output frame stack
    // This is a placeholder implementation, as the actual stack manipulation logic
    // depends on the context in which this method is used.
    // For example, if you're using a stack data structure, you might do:
    // for (int i = 0; i < slots; i++) {
    //     stack.pop();
    // }
    // Here, we assume a method 'pop()' exists that pops one slot from the stack.
    // Adjust according to your actual stack implementation.
    for (int i = 0; i < slots; i++) {
        // Pop one slot from the stack
        // stack.pop();
    }
}