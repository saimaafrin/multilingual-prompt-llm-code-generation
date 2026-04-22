import org.objectweb.asm.Frame;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Symbol;

public class FrameWriter {
    private static final int SAME_FRAME = 0;
    private static final int SAME_LOCALS_1_STACK_ITEM_FRAME = 64;
    private static final int RESERVED = 128;
    private static final int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;
    private static final int CHOP_FRAME = 248;
    private static final int SAME_FRAME_EXTENDED = 251;
    private static final int APPEND_FRAME = 252;
    private static final int FULL_FRAME = 255;

    private int[] currentFrame;
    private ByteVector stackMapTableEntries;

    private void putAbstractTypes(final int start, final int end) {
        for (int i = start; i < end; ++i) {
            putAbstractType(currentFrame[i]);
        }
    }

    private void putAbstractType(final int abstractType) {
        int type = abstractType >>> 32;
        int typeInfo = abstractType & 0xFFFFFFFFL;
        
        switch (type) {
            case Frame.ITEM_TOP:
                stackMapTableEntries.putByte(Opcodes.TOP);
                break;
            case Frame.ITEM_INTEGER:
                stackMapTableEntries.putByte(Opcodes.INTEGER);
                break;
            case Frame.ITEM_FLOAT:
                stackMapTableEntries.putByte(Opcodes.FLOAT);
                break;
            case Frame.ITEM_DOUBLE:
                stackMapTableEntries.putByte(Opcodes.DOUBLE);
                break;
            case Frame.ITEM_LONG:
                stackMapTableEntries.putByte(Opcodes.LONG);
                break;
            case Frame.ITEM_NULL:
                stackMapTableEntries.putByte(Opcodes.NULL);
                break;
            case Frame.ITEM_UNINITIALIZED_THIS:
                stackMapTableEntries.putByte(Opcodes.UNINITIALIZED_THIS);
                break;
            case Frame.ITEM_OBJECT:
                stackMapTableEntries.putByte(Opcodes.OBJECT)
                    .putShort((int) typeInfo);
                break;
            case Frame.ITEM_UNINITIALIZED:
                stackMapTableEntries.putByte(Opcodes.UNINITIALIZED)
                    .putShort((int) typeInfo);
                break;
            default:
                throw new IllegalArgumentException("Invalid abstract type: " + abstractType);
        }
    }
}