import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FieldPacker {
    private boolean isPacked;
    private int currentPosition;
    private List<Integer> packedFields;
    
    public FieldPacker() {
        this.isPacked = false;
        this.currentPosition = 0;
        this.packedFields = new ArrayList<>();
    }

    /**
     * Check if this field have been packed into a length-delimited field. If so, update internal state to reflect that packed fields are being read.
     * @throws IOException
     */
    public boolean checkPackedField() throws IOException {
        if (currentPosition > 0 && !packedFields.isEmpty()) {
            // Check if current position is within a packed field
            for (Integer packedFieldEnd : packedFields) {
                if (currentPosition < packedFieldEnd) {
                    isPacked = true;
                    return true;
                }
            }
        }
        
        isPacked = false;
        return false;
    }
    
    // Helper methods
    public void addPackedField(int endPosition) {
        packedFields.add(endPosition);
    }
    
    public void setCurrentPosition(int position) {
        this.currentPosition = position;
    }
    
    public boolean isPacked() {
        return isPacked;
    }
}