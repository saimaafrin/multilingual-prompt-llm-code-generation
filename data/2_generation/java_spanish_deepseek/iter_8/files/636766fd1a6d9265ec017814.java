public static boolean arrayequals(byte[] a, byte[] b, int count) {
    if (a == null || b == null) {
        return a == b; // Si ambos son null, son iguales; si uno es null y el otro no, son diferentes.
    }
    if (a.length < count || b.length < count) {
        return false; // Si alguno de los arreglos es más corto que count, no pueden ser iguales.
    }
    for (int i = 0; i < count; i++) {
        if (a[i] != b[i]) {
            return false; // Si algún byte no coincide, retornar false.
        }
    }
    return true; // Si todos los bytes coinciden, retornar true.
}