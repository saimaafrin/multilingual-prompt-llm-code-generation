import org.objectweb.asm.Label;
import org.objectweb.asm.Frame;
import org.objectweb.asm.MethodWriter;
import java.util.ArrayList;

public class FrameWriter {
    private byte[] stackMapTableEntries;
    private int[] currentFrame;
    private int currentIndex;
    
    private void putAbstractTypes(final int start, final int end) {
        for (int i = start; i < end; i++) {
            int abstractType = currentFrame[i];
            if (abstractType == Frame.TOP) {
                stackMapTableEntries[currentIndex++] = 0; // TOP
            } else if (abstractType == Frame.INTEGER) {
                stackMapTableEntries[currentIndex++] = 1; // INTEGER
            } else if (abstractType == Frame.FLOAT) {
                stackMapTableEntries[currentIndex++] = 2; // FLOAT
            } else if (abstractType == Frame.DOUBLE) {
                stackMapTableEntries[currentIndex++] = 3; // DOUBLE
            } else if (abstractType == Frame.LONG) {
                stackMapTableEntries[currentIndex++] = 4; // LONG
            } else if (abstractType == Frame.NULL) {
                stackMapTableEntries[currentIndex++] = 5; // NULL
            } else if (abstractType == Frame.UNINITIALIZED_THIS) {
                stackMapTableEntries[currentIndex++] = 6; // UNINITIALIZED_THIS
            } else if (abstractType == Frame.OBJECT) {
                stackMapTableEntries[currentIndex++] = 7; // OBJECT
                // Write class info index
                putInt16(currentFrame[++i]);
            } else {
                stackMapTableEntries[currentIndex++] = 8; // UNINITIALIZED
                // Write offset
                putInt16(((Label) currentFrame[++i]).getOffset());
            }
        }
    }
    
    private void putInt16(final int value) {
        stackMapTableEntries[currentIndex++] = (byte) (value >>> 8);
        stackMapTableEntries[currentIndex++] = (byte) value;
    }
}