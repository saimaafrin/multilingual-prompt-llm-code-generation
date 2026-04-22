import java.util.HashMap;
import java.util.Map;

public class FrameVisitor {
    private Map<Integer, Frame> frames = new HashMap<>();
    private Frame currentFrame;

    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Crear un nuevo frame y establecerlo como el frame actual
        currentFrame = new Frame(offset, numLocal, numStack);
        frames.put(offset, currentFrame);

        // El índice del siguiente elemento que se escribirá en este frame es 0
        return 0;
    }

    private static class Frame {
        private int offset;
        private int numLocal;
        private int numStack;
        private int nextIndex;

        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.nextIndex = 0;
        }

        public int getNextIndex() {
            return nextIndex;
        }

        public void incrementNextIndex() {
            nextIndex++;
        }
    }
}