import java.util.ArrayList;
import java.util.List;

public class StackMapFrameVisitor {
    private Frame currentFrame;
    private List<Frame> frames;
    
    // Inner class to represent a frame
    private static class Frame {
        int offset;
        int numLocal;
        int numStack;
        Object[] locals;
        Object[] stack;
        int index;
        
        Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.locals = new Object[numLocal];
            this.stack = new Object[numStack];
            this.index = 0;
        }
    }
    
    public StackMapFrameVisitor() {
        frames = new ArrayList<>();
    }
    
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Create new frame and store it as current frame
        currentFrame = new Frame(offset, numLocal, numStack);
        frames.add(currentFrame);
        
        // Start writing to local variables section
        currentFrame.index = 0;
        
        // Return current index where next element should be written
        return currentFrame.index;
    }
}