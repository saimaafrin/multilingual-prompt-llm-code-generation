import org.objectweb.asm.Frame;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodWriter;
import java.util.ArrayList;
import java.util.List;

public class StackMapTableWriter {
    private Frame currentFrame;
    private List<VerificationTypeInfo> stackMapTableEntries;
    
    public void putAbstractTypes(final int start, final int end) {
        for (int i = start; i < end; ++i) {
            int abstractType = currentFrame.getAbstractType(i);
            switch (abstractType) {
                case Frame.ITEM_TOP:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.TOP_VARIABLE_INFO));
                    break;
                case Frame.ITEM_INTEGER:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.INTEGER_VARIABLE_INFO));
                    break;
                case Frame.ITEM_FLOAT:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.FLOAT_VARIABLE_INFO));
                    break;
                case Frame.ITEM_DOUBLE:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.DOUBLE_VARIABLE_INFO));
                    break;
                case Frame.ITEM_LONG:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.LONG_VARIABLE_INFO));
                    break;
                case Frame.ITEM_NULL:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.NULL_VARIABLE_INFO));
                    break;
                case Frame.ITEM_UNINITIALIZED_THIS:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.UNINITIALIZED_THIS_VARIABLE_INFO));
                    break;
                case Frame.ITEM_OBJECT:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.OBJECT_VARIABLE_INFO, 
                        currentFrame.getObjectType(i)));
                    break;
                default:
                    if (abstractType > Frame.ITEM_UNINITIALIZED) {
                        stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.UNINITIALIZED_VARIABLE_INFO,
                            ((Label) currentFrame.getObjectType(i)).bytecodeOffset));
                    } else {
                        throw new IllegalStateException("Unknown abstract type: " + abstractType);
                    }
            }
        }
    }

    // Helper class to represent verification type info
    private static class VerificationTypeInfo {
        static final int TOP_VARIABLE_INFO = 0;
        static final int INTEGER_VARIABLE_INFO = 1;
        static final int FLOAT_VARIABLE_INFO = 2;
        static final int DOUBLE_VARIABLE_INFO = 3;
        static final int LONG_VARIABLE_INFO = 4;
        static final int NULL_VARIABLE_INFO = 5;
        static final int UNINITIALIZED_THIS_VARIABLE_INFO = 6;
        static final int OBJECT_VARIABLE_INFO = 7;
        static final int UNINITIALIZED_VARIABLE_INFO = 8;

        int tag;
        Object info;

        VerificationTypeInfo(int tag) {
            this.tag = tag;
        }

        VerificationTypeInfo(int tag, Object info) {
            this.tag = tag;
            this.info = info;
        }
    }
}