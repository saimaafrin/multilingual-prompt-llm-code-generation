public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // No operation if buffer is null or nameStart is out of bounds
    }

    // Find the first space after nameStart
    int spaceIndex = buf.indexOf(" ", nameStart);
    if (spaceIndex == -1) {
        return; // No space found, nothing to abbreviate
    }

    // Get the first character after the space
    char firstChar = buf.charAt(spaceIndex + 1);
    if (Character.isWhitespace(firstChar)) {
        return; // No valid character to abbreviate
    }

    // Replace the rest of the name with the first character and a dot
    buf.replace(spaceIndex + 1, buf.length(), String.valueOf(firstChar) + ".");
}