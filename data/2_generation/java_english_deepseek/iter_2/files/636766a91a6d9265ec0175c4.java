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
            case Type.FLOAT:
            case Type.ARRAY:
            case Type.OBJECT:
                // Pop one slot from the stack
                // Assuming a stack-like structure is managed elsewhere
                // stack.pop();
                break;
            case Type.LONG:
            case Type.DOUBLE:
                // Pop two slots from the stack
                // stack.pop();
                // stack.pop();
                break;
            case Type.VOID:
                // No action needed for void
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}