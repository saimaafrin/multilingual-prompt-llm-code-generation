import java.util.Stack;

public class FrameVisitor {
    private Stack<Frame> currentFrame;

    public FrameVisitor() {
        this.currentFrame = new Stack<>();
    }

    /**
     * एक नए स्टैक मैप फ्रेम की यात्रा शुरू करता है, जो {@link #currentFrame} में संग्रहीत है।
     * @param offset   उस निर्देश का बाइटकोड ऑफसेट, जिसके लिए फ्रेम संबंधित है।
     * @param numLocal फ्रेम में स्थानीय चर की संख्या।
     * @param numStack फ्रेम में स्टैक तत्वों की संख्या।
     * @return इस फ्रेम में लिखे जाने वाले अगले तत्व का अनुक्रमांक।
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        Frame newFrame = new Frame(offset, numLocal, numStack);
        currentFrame.push(newFrame);
        return currentFrame.size() - 1; // Return the index of the newly added frame
    }

    private static class Frame {
        private final int offset;
        private final int numLocal;
        private final int numStack;

        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
        }

        // Additional methods to manipulate the frame can be added here
    }
}