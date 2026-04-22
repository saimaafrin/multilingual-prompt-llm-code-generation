public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return;
    }

    // Split the buffer content into words
    String[] words = buf.substring(nameStart).split("\\s+");

    // Clear the buffer from the nameStart position
    buf.delete(nameStart, buf.length());

    // Append the abbreviated name
    for (String word : words) {
        if (!word.isEmpty()) {
            buf.append(word.charAt(0)).append(".");
        }
    }
}