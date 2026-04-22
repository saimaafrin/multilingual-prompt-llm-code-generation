private void putAbstractTypes(final int start, final int end) {
    // Assuming currentFrame and stackMapTableEntries are defined elsewhere in the class
    if (start < 0 || end < start || end >= currentFrame.length) {
        throw new IllegalArgumentException("Invalid start or end index");
    }

    for (int i = start; i <= end; i++) {
        // Assuming that currentFrame[i] contains the abstract type to be put into stackMapTableEntries
        stackMapTableEntries.add(currentFrame[i]);
    }
}