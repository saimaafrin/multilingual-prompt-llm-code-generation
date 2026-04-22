import org.objectweb.asm.Label;

public class LabelCreator {
    /**
     * Returns the label corresponding to the given bytecode offset. The default implementation 
     * of this method creates a label for the given offset if it has not been already created.
     * @param bytecodeOffset a bytecode offset in a method.
     * @param labels the already created labels, indexed by their offset. If a label already exists
     *              for bytecodeOffset this method must not create a new one. Otherwise it must 
     *              store the new label in this array.
     * @return a non null Label, which must be equal to labels[bytecodeOffset].
     */
    protected Label getLabelForBytecodeOffset(int bytecodeOffset, Label[] labels) {
        Label label = labels[bytecodeOffset];
        if (label == null) {
            label = new Label();
            labels[bytecodeOffset] = label;
        }
        return label;
    }
}