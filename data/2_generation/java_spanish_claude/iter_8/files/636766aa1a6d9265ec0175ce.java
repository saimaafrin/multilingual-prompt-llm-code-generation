import java.util.ArrayList;
import java.util.List;

public class StackMapFrameVisitor {
    private Frame currentFrame;
    private List<Frame> frames;
    
    public StackMapFrameVisitor() {
        frames = new ArrayList<>();
    }
    
    private static class Frame {
        int offset;
        int numLocal;
        int numStack;
        int currentIndex;
        
        Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal; 
            this.numStack = numStack;
            this.currentIndex = 0;
        }
    }
    
    /**
     * Inicia la visita de un nuevo "stack map frame", almacenado en {@link #currentFrame}.
     * @param offset   el desplazamiento de bytecode de la instrucción a la que corresponde el "frame".
     * @param numLocal el número de variables locales en el "frame".
     * @param numStack el número de elementos apilados en el "frame".
     * @return el índice del siguiente elemento que se escribirá en este "frame".
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        currentFrame = new Frame(offset, numLocal, numStack);
        frames.add(currentFrame);
        return currentFrame.currentIndex;
    }
}