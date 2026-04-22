import org.objectweb.asm.Frame;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodWriter;
import org.objectweb.asm.Opcodes;

public class StackMapTableWriter {
    private byte[] stackMapTableEntries;
    private Frame currentFrame;
    private int currentIndex = 0;
    
    private void putAbstractTypes(final int start, final int end) {
        for (int i = start; i < end; ++i) {
            putAbstractType(currentFrame.getLocal(i));
        }
    }
    
    private void putAbstractType(final int abstractType) {
        int type = abstractType & Frame.DIM_MASK;
        if (type == Frame.OBJECT) {
            stackMapTableEntries[currentIndex++] = (byte) Frame.ITEM_OBJECT;
            // Write class info
            int classIndex = abstractType & Frame.VALUE_MASK;
            stackMapTableEntries[currentIndex++] = (byte)(classIndex >>> 8);
            stackMapTableEntries[currentIndex++] = (byte)classIndex;
        } else if (type == Frame.UNINITIALIZED) {
            stackMapTableEntries[currentIndex++] = (byte) Frame.ITEM_UNINITIALIZED;
            // Write offset
            int offset = abstractType & Frame.VALUE_MASK;
            stackMapTableEntries[currentIndex++] = (byte)(offset >>> 8);
            stackMapTableEntries[currentIndex++] = (byte)offset;
        } else {
            stackMapTableEntries[currentIndex++] = (byte) type;
        }
    }
}