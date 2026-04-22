/**
 * 'Content-Range' HTTP हेडर मान बनाएं।
 * @return 'Content-Range' मान
 */
private String buildContentRange() {
    // Assuming some default values for start, end, and total size
    long start = 0;
    long end = 1023; // Example end value
    long totalSize = 2048; // Example total size

    // Format the Content-Range header value
    return String.format("bytes %d-%d/%d", start, end, totalSize);
}