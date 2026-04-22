import org.objectweb.asm.Label;
import org.objectweb.asm.Frame;
import org.objectweb.asm.MethodWriter;
import org.objectweb.asm.ByteVector;
import org.objectweb.asm.Type;

public class StackMapTableWriter {
    private ByteVector stackMapTableEntries;
    private Frame currentFrame;
    private static final int ITEM_TOP = 0;
    private static final int ITEM_INTEGER = 1;
    private static final int ITEM_FLOAT = 2;
    private static final int ITEM_DOUBLE = 3;
    private static final int ITEM_LONG = 4;
    private static final int ITEM_NULL = 5;
    private static final int ITEM_UNINITIALIZED_THIS = 6;
    private static final int ITEM_OBJECT = 7;
    private static final int ITEM_UNINITIALIZED = 8;

    private void putAbstractTypes(final int start, final int end) {
        for (int i = start; i < end; i++) {
            Object type = currentFrame.getStack(i);
            if (type instanceof Integer) {
                int value = (Integer) type;
                switch (value) {
                    case ITEM_TOP:
                        stackMapTableEntries.putByte(0);
                        break;
                    case ITEM_INTEGER:
                        stackMapTableEntries.putByte(1);
                        break;
                    case ITEM_FLOAT:
                        stackMapTableEntries.putByte(2);
                        break;
                    case ITEM_DOUBLE:
                        stackMapTableEntries.putByte(3);
                        break;
                    case ITEM_LONG:
                        stackMapTableEntries.putByte(4);
                        break;
                    case ITEM_NULL:
                        stackMapTableEntries.putByte(5);
                        break;
                    case ITEM_UNINITIALIZED_THIS:
                        stackMapTableEntries.putByte(6);
                        break;
                }
            } else if (type instanceof String) {
                stackMapTableEntries.putByte(7);
                stackMapTableEntries.putShort(((String) type).hashCode());
            } else if (type instanceof Label) {
                stackMapTableEntries.putByte(8);
                stackMapTableEntries.putShort(((Label) type).getOffset());
            }
        }
    }
}