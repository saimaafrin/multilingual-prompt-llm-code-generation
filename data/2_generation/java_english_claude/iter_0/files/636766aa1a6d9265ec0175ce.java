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
        List<Object> elements;
        
        Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.elements = new ArrayList<>();
        }
    }
    
    public StackMapFrameVisitor() {
        frames = new ArrayList<>();
    }
    
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Create new frame and store it as current frame
        currentFrame = new Frame(offset, numLocal, numStack);
        frames.add(currentFrame);
        
        // Return starting index for writing elements
        // Local variables are written first, followed by stack elements
        return 0;
    }
}