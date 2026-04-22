public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // Invalid input, do nothing
    }

    // Split the buffer content into words
    String[] words = buf.substring(nameStart).split("\\s+");

    // Abbreviate each word (keep first letter)
    for (int i = 0; i < words.length; i++) {
        if (!words[i].isEmpty()) {
            words[i] = words[i].substring(0, 1).toUpperCase();
        }
    }

    // Join the abbreviated words and replace the original content
    String abbreviatedName = String.join(".", words);
    buf.replace(nameStart, buf.length(), abbreviatedName);
}