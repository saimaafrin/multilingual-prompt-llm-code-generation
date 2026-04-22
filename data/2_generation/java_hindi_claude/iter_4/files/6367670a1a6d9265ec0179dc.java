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
                case Frame.TOP:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.TOP_TYPE));
                    break;
                case Frame.INTEGER:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.INTEGER_TYPE));
                    break;
                case Frame.FLOAT:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.FLOAT_TYPE));
                    break;
                case Frame.DOUBLE:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.DOUBLE_TYPE));
                    break;
                case Frame.LONG:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.LONG_TYPE));
                    break;
                case Frame.NULL:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.NULL_TYPE));
                    break;
                case Frame.UNINITIALIZED_THIS:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.UNINITIALIZED_THIS_TYPE));
                    break;
                default:
                    if (abstractType >= Frame.OBJECT && abstractType <= Frame.OBJECT_MAX) {
                        String className = currentFrame.getObjectType(i);
                        stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.OBJECT_TYPE, className));
                    } else if (abstractType >= Frame.UNINITIALIZED && abstractType <= Frame.UNINITIALIZED_MAX) {
                        Label label = currentFrame.getUninitializedLabel(i);
                        stackMapTableEntries.add(new VerificationTypeInfo(VerificationTypeInfo.UNINITIALIZED_TYPE, label));
                    }
                    break;
            }
        }
    }

    // Inner class to represent verification type info
    private static class VerificationTypeInfo {
        static final int TOP_TYPE = 0;
        static final int INTEGER_TYPE = 1;
        static final int FLOAT_TYPE = 2;
        static final int DOUBLE_TYPE = 3;
        static final int LONG_TYPE = 4;
        static final int NULL_TYPE = 5;
        static final int UNINITIALIZED_THIS_TYPE = 6;
        static final int OBJECT_TYPE = 7;
        static final int UNINITIALIZED_TYPE = 8;

        private int type;
        private Object info;

        VerificationTypeInfo(int type) {
            this.type = type;
        }

        VerificationTypeInfo(int type, Object info) {
            this.type = type;
            this.info = info;
        }
    }
}