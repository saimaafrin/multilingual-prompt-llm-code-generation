public static boolean arrayequals(byte[] a, byte[] b, int count) {
    // Verificar si alguno de los arreglos es nulo
    if (a == null || b == null) {
        return false;
    }

    // Verificar si el count es mayor que la longitud de alguno de los arreglos
    if (count > a.length || count > b.length) {
        return false;
    }

    // Comparar los primeros 'count' bytes de ambos arreglos
    for (int i = 0; i < count; i++) {
        if (a[i] != b[i]) {
            return false;
        }
    }

    return true;
}