public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // No operation if buffer is null or start index is invalid
    }

    // Find the first space after the nameStart
    int spaceIndex = buf.indexOf(" ", nameStart);
    if (spaceIndex == -1) {
        return; // No space found, nothing to abbreviate
    }

    // Replace the characters between nameStart and spaceIndex with the first character
    char firstChar = buf.charAt(nameStart);
    buf.replace(nameStart + 1, spaceIndex, ".");
}