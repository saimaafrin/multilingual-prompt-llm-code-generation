/**
 * Espande questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
 * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
 */
private void enlarge(final int size) {
    // Supponiamo che 'buffer' sia l'array di byte che vogliamo espandere
    byte[] newBuffer = new byte[buffer.length + size];
    
    // Copia i dati dal vecchio buffer al nuovo buffer
    System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
    
    // Aggiorna il riferimento al nuovo buffer
    buffer = newBuffer;
}