public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // No operation if buffer is null or nameStart is out of bounds
    }

    // Split the string into parts starting from nameStart
    String name = buf.substring(nameStart);
    String[] parts = name.split("\\s+"); // Split by whitespace

    if (parts.length == 0) {
        return; // No parts to abbreviate
    }

    // Abbreviate each part except the last one
    for (int i = 0; i < parts.length - 1; i++) {
        if (!parts[i].isEmpty()) {
            parts[i] = parts[i].substring(0, 1) + "."; // Take the first character and add a dot
        }
    }

    // Reconstruct the abbreviated name
    String abbreviatedName = String.join(" ", parts);

    // Replace the original name with the abbreviated version
    buf.replace(nameStart, buf.length(), abbreviatedName);
}