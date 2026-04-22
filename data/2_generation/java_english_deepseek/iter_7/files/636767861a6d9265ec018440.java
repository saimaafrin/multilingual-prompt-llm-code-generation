public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // Handle invalid input
    }

    // Split the buffer content into words starting from nameStart
    String content = buf.substring(nameStart);
    String[] words = content.split("\\s+");

    // Abbreviate each word except the last one
    for (int i = 0; i < words.length - 1; i++) {
        if (!words[i].isEmpty()) {
            words[i] = words[i].charAt(0) + ".";
        }
    }

    // Reconstruct the abbreviated name
    String abbreviatedName = String.join(" ", words);

    // Replace the original content with the abbreviated name
    buf.replace(nameStart, buf.length(), abbreviatedName);
}