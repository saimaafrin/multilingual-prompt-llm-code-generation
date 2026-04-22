import org.objectweb.asm.Frame;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodWriter;
import org.objectweb.asm.Opcodes;

public class StackMapTableWriter {
    private byte[] stackMapTableEntries;
    private Frame[] currentFrame;
    private int currentIndex;
    
    private void putAbstractTypes(final int start, final int end) {
        for (int i = start; i < end; i++) {
            int abstractType = currentFrame[i].getType();
            if (abstractType == Opcodes.TOP) {
                stackMapTableEntries[currentIndex++] = 0;
            } else if (abstractType == Opcodes.INTEGER) {
                stackMapTableEntries[currentIndex++] = 1;
            } else if (abstractType == Opcodes.FLOAT) {
                stackMapTableEntries[currentIndex++] = 2;
            } else if (abstractType == Opcodes.DOUBLE) {
                stackMapTableEntries[currentIndex++] = 3;
            } else if (abstractType == Opcodes.LONG) {
                stackMapTableEntries[currentIndex++] = 4;
            } else if (abstractType == Opcodes.NULL) {
                stackMapTableEntries[currentIndex++] = 5;
            } else if (abstractType == Opcodes.UNINITIALIZED_THIS) {
                stackMapTableEntries[currentIndex++] = 6;
            } else if (abstractType == Opcodes.OBJECT) {
                stackMapTableEntries[currentIndex++] = 7;
                // Write class info index
                putShort(currentFrame[i].getObjectType());
            } else {
                // UNINITIALIZED
                stackMapTableEntries[currentIndex++] = 8;
                // Write offset
                putShort(((Label) currentFrame[i].getObjectType()).getOffset());
            }
        }
    }
    
    private void putShort(final int value) {
        stackMapTableEntries[currentIndex++] = (byte) (value >>> 8);
        stackMapTableEntries[currentIndex++] = (byte) value;
    }
}