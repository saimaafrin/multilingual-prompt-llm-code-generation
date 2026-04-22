/**
 * 'Content-Range' HTTP हेडर मान बनाएं।
 * @return 'Content-Range' मान
 */
private String buildContentRange() {
    // Assuming some default values for start, end, and total size
    int start = 0;
    int end = 1023; // Example end value
    int totalSize = 2048; // Example total size

    // Format the Content-Range header value
    return String.format("bytes %d-%d/%d", start, end, totalSize);
}