public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // Handle invalid input
    }

    // Split the name into parts based on spaces
    String[] parts = buf.substring(nameStart).split(" ");

    // Clear the buffer from the nameStart position
    buf.delete(nameStart, buf.length());

    // Append the abbreviated name
    for (int i = 0; i < parts.length; i++) {
        if (!parts[i].isEmpty()) {
            buf.append(parts[i].charAt(0)); // Append the first character of each part
            if (i < parts.length - 1) {
                buf.append('.'); // Append a dot after each abbreviation except the last
            }
        }
    }
}