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
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.TOP));
                    break;
                case Frame.ITEM_INTEGER:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.INTEGER));
                    break;
                case Frame.ITEM_FLOAT:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.FLOAT));
                    break;
                case Frame.ITEM_DOUBLE:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.DOUBLE));
                    break;
                case Frame.ITEM_LONG:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.LONG));
                    break;
                case Frame.ITEM_NULL:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.NULL));
                    break;
                case Frame.ITEM_UNINITIALIZED_THIS:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.UNINITIALIZED_THIS));
                    break;
                case Frame.ITEM_OBJECT:
                    stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.OBJECT, 
                        currentFrame.getObjectType(i)));
                    break;
                default:
                    if (abstractType > Frame.ITEM_UNINITIALIZED) {
                        stackMapTableEntries.add(new VerificationTypeInfo(VerificationType.UNINITIALIZED,
                            currentFrame.getUninitializedTypeOffset(i)));
                    }
                    break;
            }
        }
    }
    
    private enum VerificationType {
        TOP,
        INTEGER,
        FLOAT,
        DOUBLE,
        LONG,
        NULL,
        UNINITIALIZED_THIS,
        OBJECT,
        UNINITIALIZED
    }
    
    private static class VerificationTypeInfo {
        private VerificationType type;
        private Object extraInfo; // For OBJECT (class name) or UNINITIALIZED (offset)
        
        public VerificationTypeInfo(VerificationType type) {
            this.type = type;
        }
        
        public VerificationTypeInfo(VerificationType type, Object extraInfo) {
            this.type = type;
            this.extraInfo = extraInfo;
        }
    }
}