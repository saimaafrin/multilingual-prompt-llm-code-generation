import org.objectweb.asm.Label;

public class LabelCreator {
    public Label getLabelForBytecodeOffset(int bytecodeOffset, Label[] labels) {
        // If label already exists at this offset, return it
        if (labels[bytecodeOffset] != null) {
            return labels[bytecodeOffset];
        }
        
        // Create new label if none exists
        Label newLabel = new Label();
        labels[bytecodeOffset] = newLabel;
        return newLabel;
    }
}