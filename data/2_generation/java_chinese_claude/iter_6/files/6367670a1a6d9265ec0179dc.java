import org.objectweb.asm.Frame;
import org.objectweb.asm.Label;
import org.objectweb.asm.SymbolTable;
import org.objectweb.asm.ByteVector;

public class StackMapTableWriter {
    private ByteVector stackMapTableEntries;
    private Frame currentFrame;
    private SymbolTable symbolTable;
    
    private void putAbstractTypes(final int start, final int end) {
        for (int i = start; i < end; ++i) {
            putAbstractType(currentFrame.getLocal(i));
        }
    }
    
    private void putAbstractType(final int abstractType) {
        int type = abstractType >>> 32;
        int typeInfo = abstractType & 0xFFFFFFFFL;
        
        switch (type) {
            case Frame.ITEM_TOP:
                stackMapTableEntries.putByte(0);
                break;
            case Frame.ITEM_INTEGER:
                stackMapTableEntries.putByte(1);
                break;
            case Frame.ITEM_FLOAT:
                stackMapTableEntries.putByte(2);
                break;
            case Frame.ITEM_DOUBLE:
                stackMapTableEntries.putByte(3);
                break;
            case Frame.ITEM_LONG:
                stackMapTableEntries.putByte(4);
                break;
            case Frame.ITEM_NULL:
                stackMapTableEntries.putByte(5);
                break;
            case Frame.ITEM_UNINITIALIZED_THIS:
                stackMapTableEntries.putByte(6);
                break;
            case Frame.ITEM_OBJECT:
                stackMapTableEntries.putByte(7);
                stackMapTableEntries.putShort(symbolTable.addConstantClass((String)typeInfo).index);
                break;
            case Frame.ITEM_UNINITIALIZED:
                stackMapTableEntries.putByte(8);
                stackMapTableEntries.putShort(((Label)typeInfo).bytecodeOffset);
                break;
            default:
                throw new IllegalArgumentException("Invalid abstract type: " + abstractType);
        }
    }
}