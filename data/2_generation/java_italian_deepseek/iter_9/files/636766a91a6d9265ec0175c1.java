/**
 * Espande questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
 * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
 */
private void enlarge(final int size) {
    if (size <= 0) {
        throw new IllegalArgumentException("Size must be greater than 0");
    }

    // Assuming 'buffer' is the byte array that needs to be enlarged
    byte[] newBuffer = new byte[buffer.length + size];
    System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
    buffer = newBuffer;
}