public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // No operation if buffer is null or start index is invalid
    }

    // Split the string into parts starting from nameStart
    String fullName = buf.substring(nameStart);
    String[] parts = fullName.split("\\s+"); // Split by whitespace

    if (parts.length == 0) {
        return; // No name parts to abbreviate
    }

    // Abbreviate each part except the last one
    StringBuilder abbreviatedName = new StringBuilder();
    for (int i = 0; i < parts.length - 1; i++) {
        if (!parts[i].isEmpty()) {
            abbreviatedName.append(parts[i].charAt(0)).append(".");
        }
    }

    // Append the last part as is
    abbreviatedName.append(parts[parts.length - 1]);

    // Replace the original name with the abbreviated version
    buf.replace(nameStart, buf.length(), abbreviatedName.toString());
}