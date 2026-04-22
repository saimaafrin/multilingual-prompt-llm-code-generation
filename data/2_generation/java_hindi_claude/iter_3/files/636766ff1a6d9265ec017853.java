import org.objectweb.asm.Label;

public class LabelCreator {
    public Label getLabelForBytecodeOffset(int bytecodeOffset, Label[] labels) {
        Label label = labels[bytecodeOffset];
        if (label == null) {
            label = new Label();
            labels[bytecodeOffset] = label;
        }
        return label;
    }
}