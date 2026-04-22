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
            stackMapTableEntries[currentIndex++] = Frame.ITEM_OBJECT;
            putClass(abstractType & Frame.VALUE_MASK);
        } else if (type == Frame.UNINITIALIZED) {
            stackMapTableEntries[currentIndex++] = Frame.ITEM_UNINITIALIZED;
            putUnsignedShort(abstractType & Frame.VALUE_MASK);
        } else {
            stackMapTableEntries[currentIndex++] = ITEM_TYPES[type];
        }
    }
    
    private void putClass(final int symbolTableIndex) {
        putUnsignedShort(symbolTableIndex);
    }
    
    private void putUnsignedShort(final int value) {
        stackMapTableEntries[currentIndex++] = (byte)(value >>> 8);
        stackMapTableEntries[currentIndex++] = (byte)value;
    }
    
    private static final int[] ITEM_TYPES = {
        Frame.ITEM_TOP,
        Frame.ITEM_INTEGER,
        Frame.ITEM_FLOAT,
        Frame.ITEM_DOUBLE,
        Frame.ITEM_LONG,
        Frame.ITEM_NULL,
        Frame.ITEM_UNINITIALIZED_THIS,
        Frame.ITEM_OBJECT,
        Frame.ITEM_UNINITIALIZED
    };
}