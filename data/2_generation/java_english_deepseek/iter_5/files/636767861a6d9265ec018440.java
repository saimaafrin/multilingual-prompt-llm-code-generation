public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // Handle invalid input
    }

    // Split the name into parts based on spaces
    String name = buf.substring(nameStart);
    String[] parts = name.split(" ");

    // Abbreviate each part except the last one
    for (int i = 0; i < parts.length - 1; i++) {
        if (!parts[i].isEmpty()) {
            parts[i] = parts[i].substring(0, 1) + ".";
        }
    }

    // Reconstruct the abbreviated name
    String abbreviatedName = String.join(" ", parts);

    // Replace the original name with the abbreviated name in the buffer
    buf.replace(nameStart, buf.length(), abbreviatedName);
}