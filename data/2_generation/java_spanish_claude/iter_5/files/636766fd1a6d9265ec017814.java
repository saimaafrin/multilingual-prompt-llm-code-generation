public class ArrayUtils {
    /**
     * Compara los <code>count</code> primeros bytes en los arreglos <code>a</code> y <code>b</code>.
     * @param a     El primer arreglo a comparar.
     * @param b     El segundo arreglo a comparar. 
     * @param count Cuántos bytes se deben comparar.
     * @return <code>true</code> si los <code>count</code> primeros bytes en los arreglos <code>a</code> y <code>b</code> son iguales.
     */
    public static boolean arrayequals(byte[] a, byte[] b, int count) {
        // Verificar que los arreglos no sean null
        if (a == null || b == null) {
            return false;
        }
        
        // Verificar que count sea válido
        if (count < 0) {
            return false;
        }
        
        // Verificar que los arreglos tengan suficientes elementos
        if (a.length < count || b.length < count) {
            return false;
        }
        
        // Comparar los primeros count bytes
        for (int i = 0; i < count; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        return true;
    }
}