import java.io.IOException;

public class PackedFieldChecker {

    private boolean isPackedField;

    /** 
     * Check if this field have been packed into a length-delimited field. If so, update internal state to reflect that packed fields are being read.
     * @throws IOException
     */
    private void checkIfPackedField() throws IOException {
        // Logic to determine if the field is packed
        // This is a placeholder for the actual implementation
        // For example, we might check a certain condition or flag
        if (isPackedField) {
            // Update internal state if packed field is detected
            // This could involve setting a flag or performing some action
            System.out.println("Packed field detected. Updating internal state.");
        } else {
            // If not packed, we might throw an exception or handle it differently
            throw new IOException("Field is not packed.");
        }
    }

    // Method to simulate setting the packed field state
    public void setPackedField(boolean packed) {
        this.isPackedField = packed;
    }

    public static void main(String[] args) {
        PackedFieldChecker checker = new PackedFieldChecker();
        checker.setPackedField(true); // Simulate setting the packed field
        try {
            checker.checkIfPackedField(); // Check if packed field
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}