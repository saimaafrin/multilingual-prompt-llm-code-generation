import java.util.List;

public class StackMapTable {
    private List<Object> currentFrame;
    private List<Object> stackMapTableEntries;

    /**
     * Puts some abstract types of {@link #currentFrame} in {@link #stackMapTableEntries},
     * using the JVMS verification_type_info format used in StackMapTable attributes.
     * @param start index of the first type in {@link #currentFrame} to write.
     * @param end index of last type in {@link #currentFrame} to write (exclusive).
     */
    private void putAbstractTypes(final int start, final int end) {
        if (start < 0 || end > currentFrame.size() || start > end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }

        for (int i = start; i < end; i++) {
            Object type = currentFrame.get(i);
            stackMapTableEntries.add(type);
        }
    }
}