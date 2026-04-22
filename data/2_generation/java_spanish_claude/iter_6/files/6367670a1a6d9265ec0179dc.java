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
            if (abstractType == Frame.TOP || abstractType == Frame.UNINITIALIZED_THIS 
                    || abstractType == Frame.NULL || abstractType == Frame.INTEGER
                    || abstractType == Frame.FLOAT) {
                stackMapTableEntries[currentIndex++] = (byte) abstractType;
            } else if (abstractType == Frame.LONG) {
                stackMapTableEntries[currentIndex++] = (byte) Frame.LONG;
                stackMapTableEntries[currentIndex++] = (byte) Frame.TOP;
                i++;
            } else if (abstractType == Frame.DOUBLE) {
                stackMapTableEntries[currentIndex++] = (byte) Frame.DOUBLE;
                stackMapTableEntries[currentIndex++] = (byte) Frame.TOP;
                i++;
            } else if (abstractType == Frame.UNINITIALIZED) {
                stackMapTableEntries[currentIndex++] = (byte) Frame.UNINITIALIZED;
                int offset = ((Label) currentFrame[++i]).getOffset();
                stackMapTableEntries[currentIndex++] = (byte) (offset >>> 8);
                stackMapTableEntries[currentIndex++] = (byte) offset;
            } else {
                stackMapTableEntries[currentIndex++] = (byte) Frame.OBJECT;
                int typeIndex = abstractType;
                stackMapTableEntries[currentIndex++] = (byte) (typeIndex >>> 8);
                stackMapTableEntries[currentIndex++] = (byte) typeIndex;
            }
        }
    }
}