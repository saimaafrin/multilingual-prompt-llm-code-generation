public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // Invalid input, do nothing
    }

    // Split the buffer into parts
    String fullName = buf.toString();
    String[] parts = fullName.split(" ");

    // Abbreviate each part except the last one
    for (int i = 0; i < parts.length - 1; i++) {
        if (!parts[i].isEmpty()) {
            parts[i] = parts[i].charAt(0) + ".";
        }
    }

    // Reconstruct the abbreviated name
    String abbreviatedName = String.join(" ", parts);

    // Replace the original content in the buffer
    buf.replace(0, buf.length(), abbreviatedName);
}