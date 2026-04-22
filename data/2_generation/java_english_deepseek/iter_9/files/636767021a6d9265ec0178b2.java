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
            case Type.BYTE:
            case Type.CHAR:
            case Type.SHORT:
            case Type.INT:
                // Pop int
                // Assuming outputFrameStack is a stack-like structure
                outputFrameStack.pop();
                break;
            case Type.LONG:
                // Pop long (takes two slots)
                outputFrameStack.pop();
                outputFrameStack.pop();
                break;
            case Type.FLOAT:
                // Pop float
                outputFrameStack.pop();
                break;
            case Type.DOUBLE:
                // Pop double (takes two slots)
                outputFrameStack.pop();
                outputFrameStack.pop();
                break;
            case Type.ARRAY:
            case Type.OBJECT:
                // Pop reference
                outputFrameStack.pop();
                break;
            case Type.VOID:
                // No pop for void
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}