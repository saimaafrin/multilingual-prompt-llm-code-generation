/**
 * 'Content-Range' HTTP हेडर मान बनाएं।
 * @return 'Content-Range' मान
 */
private String buildContentRange() {
    // Assuming the content length and range are known
    int start = 0; // Starting byte position
    int end = 1023; // Ending byte position
    int total = 2048; // Total size of the content

    // Format: "bytes start-end/total"
    return String.format("bytes %d-%d/%d", start, end, total);
}