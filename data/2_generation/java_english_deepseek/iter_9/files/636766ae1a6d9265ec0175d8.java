/**
 * Build the 'Content-Range' HTTP Header value.
 * @return 'Content-Range' value
 */
private String buildContentRange() {
    // Assuming the content range is for a file of size 1000 bytes, starting from byte 0 to 999
    long fileSize = 1000; // Example file size
    long startByte = 0;   // Starting byte
    long endByte = fileSize - 1; // Ending byte

    return String.format("bytes %d-%d/%d", startByte, endByte, fileSize);
}