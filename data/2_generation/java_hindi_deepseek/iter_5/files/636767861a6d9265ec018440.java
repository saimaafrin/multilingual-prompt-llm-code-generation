public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return;
    }

    // Split the buffer into words
    String[] words = buf.substring(nameStart).split("\\s+");

    // Clear the buffer from nameStart
    buf.delete(nameStart, buf.length());

    // Append the abbreviated name
    for (int i = 0; i < words.length; i++) {
        if (i > 0) {
            buf.append(" ");
        }
        if (words[i].length() > 0) {
            buf.append(words[i].charAt(0));
        }
    }
}