import java.util.Stack;

public class FrameStack {
    private Stack<Object> outputFrame;

    public FrameStack() {
        outputFrame = new Stack<>();
    }

    /**
     * Elimina el número dado de tipos abstractos del "output frame" de salida.
     * @param elements el número de tipos abstractos que deben ser eliminados.
     */
    private void pop(final int elements) {
        for (int i = 0; i < elements; i++) {
            if (!outputFrame.isEmpty()) {
                outputFrame.pop();
            }
        }
    }
}