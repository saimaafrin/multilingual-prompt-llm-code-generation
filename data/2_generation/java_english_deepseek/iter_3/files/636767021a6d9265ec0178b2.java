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
                // Pop int
                break;
            case Type.FLOAT:
                // Pop float
                break;
            case Type.LONG:
                // Pop long
                break;
            case Type.DOUBLE:
                // Pop double
                break;
            case Type.ARRAY:
            case Type.OBJECT:
                // Pop reference
                break;
            case Type.VOID:
                // No pop needed
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }
}