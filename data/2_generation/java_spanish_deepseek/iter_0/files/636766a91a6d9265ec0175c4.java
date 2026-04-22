import java.util.Stack;

public class FrameStackHandler {

    private Stack<String> frameStack;

    public FrameStackHandler() {
        this.frameStack = new Stack<>();
    }

    /**
     * Extrae tantos tipos abstractos de la "frame stack" de salida como lo describe el descriptor dado.
     * @param descriptor un descriptor de tipo o método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            throw new IllegalArgumentException("Descriptor cannot be null or empty");
        }

        // Determine if the descriptor is a method descriptor
        if (descriptor.startsWith("(")) {
            // Extract argument types from method descriptor
            String[] argumentTypes = extractArgumentTypes(descriptor);
            for (String type : argumentTypes) {
                if (!frameStack.isEmpty()) {
                    frameStack.pop();
                } else {
                    throw new IllegalStateException("Frame stack is empty");
                }
            }
        } else {
            // Single type descriptor
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("Frame stack is empty");
            }
        }
    }

    private String[] extractArgumentTypes(String methodDescriptor) {
        // Remove the leading '(' and trailing ')'
        String argsPart = methodDescriptor.substring(1, methodDescriptor.indexOf(')'));
        return argsPart.split(";");
    }

    // For testing purposes
    public void pushToStack(String type) {
        frameStack.push(type);
    }

    public Stack<String> getFrameStack() {
        return frameStack;
    }

    public static void main(String[] args) {
        FrameStackHandler handler = new FrameStackHandler();
        handler.pushToStack("Ljava/lang/String;");
        handler.pushToStack("I");
        handler.pushToStack("D");

        handler.pop("(Ljava/lang/String;ID)V");

        System.out.println(handler.getFrameStack()); // Should print: []
    }
}