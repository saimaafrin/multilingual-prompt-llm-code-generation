import java.io.IOException;

private void checkIfPackedField() throws IOException {
    // Assuming 'packed' is a boolean flag indicating if the field is packed
    if (packed) {
        // Update internal state to reflect that packed fields are being read
        // For example, set a flag or update a counter
        readingPackedFields = true;
        packedFieldCounter = 0; // Reset counter if needed
    } else {
        // If not packed, ensure the state reflects that
        readingPackedFields = false;
    }
}