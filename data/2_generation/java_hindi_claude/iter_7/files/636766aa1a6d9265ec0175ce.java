import java.util.ArrayList;
import java.util.List;

public class StackMapFrameVisitor {
    private Frame currentFrame;
    private List<Frame> frames;
    
    public StackMapFrameVisitor() {
        frames = new ArrayList<>();
    }
    
    protected int startFrame(final int offset, final int numLocal, final int numStack) {
        currentFrame = new Frame(offset, numLocal, numStack);
        frames.add(currentFrame);
        return 0;
    }
    
    // Helper Frame class to store frame data
    private static class Frame {
        private int offset;
        private int numLocal;
        private int numStack;
        
        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal; 
            this.numStack = numStack;
        }
    }
}