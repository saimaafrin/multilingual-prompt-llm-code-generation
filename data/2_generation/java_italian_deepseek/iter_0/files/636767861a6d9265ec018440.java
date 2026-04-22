public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // Invalid input, do nothing
    }

    // Find the first space after nameStart
    int spaceIndex = buf.indexOf(" ", nameStart);
    if (spaceIndex == -1) {
        return; // No space found, do nothing
    }

    // Abbreviate the name by taking the first character and adding a dot
    buf.replace(nameStart + 1, spaceIndex, ".");
}