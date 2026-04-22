public static boolean arrayequals(byte[] a, byte[] b, int count) {
    if (a == null || b == null) {
        return a == b; // Se entrambi sono null, sono uguali; altrimenti no.
    }
    if (a.length < count || b.length < count) {
        return false; // Se uno degli array è più corto di count, non possono essere uguali.
    }
    for (int i = 0; i < count; i++) {
        if (a[i] != b[i]) {
            return false; // Se un byte non corrisponde, restituisci false.
        }
    }
    return true; // Tutti i byte corrispondono.
}