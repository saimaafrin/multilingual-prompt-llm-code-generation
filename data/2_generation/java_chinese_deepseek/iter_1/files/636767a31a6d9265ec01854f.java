import java.io.IOException;

private void checkIfPackedField() throws IOException {
    // Assuming 'packedField' is a boolean flag indicating if the field is packed
    if (packedField) {
        // Update internal state to reflect that we are reading a packed field
        // For example, set a flag or update a counter
        isReadingPackedField = true;
        packedFieldCounter++;
    } else {
        // Reset the state if the field is not packed
        isReadingPackedField = false;
        packedFieldCounter = 0;
    }
}