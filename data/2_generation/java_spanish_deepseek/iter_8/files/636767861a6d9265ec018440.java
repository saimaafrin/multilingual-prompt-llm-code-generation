public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // No operation if buffer is null or start index is invalid
    }

    // Split the string into words starting from nameStart
    String[] words = buf.substring(nameStart).split("\\s+");

    // Clear the buffer from nameStart onwards
    buf.delete(nameStart, buf.length());

    // Append the abbreviated name
    for (int i = 0; i < words.length; i++) {
        if (i > 0) {
            buf.append(" "); // Add space between words
        }
        if (words[i].length() > 0) {
            buf.append(words[i].charAt(0)); // Append the first character of each word
        }
    }
}