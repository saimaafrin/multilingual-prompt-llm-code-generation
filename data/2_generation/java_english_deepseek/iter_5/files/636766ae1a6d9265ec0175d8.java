/**
 * Build the 'Content-Range' HTTP Header value.
 * @return 'Content-Range' value
 */
private String buildContentRange() {
    // Assuming the range and total size are known or calculated elsewhere in the class
    long startRange = 0; // Example start range
    long endRange = 1023; // Example end range
    long totalSize = 2048; // Example total size

    // Format: "bytes start-end/total"
    return String.format("bytes %d-%d/%d", startRange, endRange, totalSize);
}