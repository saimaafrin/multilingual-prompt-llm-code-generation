import java.io.IOException;

private void checkIfPackedField() throws IOException {
    // Assuming 'packedField' is a boolean flag indicating if the field is packed
    if (packedField) {
        // Update internal state to reflect that a packed field is being read
        // For example, setting a flag or updating a counter
        isReadingPackedField = true;
        packedFieldCounter++;
    } else {
        // Reset the state if the field is not packed
        isReadingPackedField = false;
        packedFieldCounter = 0;
    }
}