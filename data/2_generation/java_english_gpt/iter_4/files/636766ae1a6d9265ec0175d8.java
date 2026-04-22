private String buildContentRange() {
    long totalSize = 1000; // Example total size of the resource
    long start = 0; // Example start byte
    long end = 499; // Example end byte

    return String.format("bytes %d-%d/%d", start, end, totalSize);
}