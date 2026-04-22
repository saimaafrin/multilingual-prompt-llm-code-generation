import org.objectweb.asm.Label;

public class LabelReader {
    
    /**
     * 返回与给定字节码偏移量对应的标签。如果该标签尚未被创建，该方法的默认实现会为给定的偏移量创建一个标签。
     * @param bytecodeOffset 方法中的字节码偏移量。
     * @param labels 已创建的标签数组，按其偏移量索引。如果bytecodeOffset已经存在标签，则此方法不得创建新的标签。否则，它必须将新标签存储在此数组中。
     * @return 一个非空的标签，必须等于labels[bytecodeOffset]。
     */
    protected Label readLabel(final int bytecodeOffset, final Label[] labels) {
        Label label = labels[bytecodeOffset];
        if (label == null) {
            label = new Label();
            labels[bytecodeOffset] = label;
        }
        return label;
    }
}