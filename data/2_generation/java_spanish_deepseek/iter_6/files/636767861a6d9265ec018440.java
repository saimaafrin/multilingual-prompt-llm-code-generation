public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // No operation if buffer is null or nameStart is out of bounds
    }

    // Split the string into parts starting from nameStart
    String fullName = buf.substring(nameStart);
    String[] parts = fullName.split("\\s+");

    // Abbreviate each part except the last one
    for (int i = 0; i < parts.length - 1; i++) {
        if (!parts[i].isEmpty()) {
            parts[i] = parts[i].charAt(0) + ".";
        }
    }

    // Reconstruct the abbreviated name
    String abbreviatedName = String.join(" ", parts);

    // Replace the original name with the abbreviated name in the buffer
    buf.replace(nameStart, buf.length(), abbreviatedName);
}