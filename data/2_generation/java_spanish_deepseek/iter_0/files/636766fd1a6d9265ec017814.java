public class ArrayComparator {
    /**
     * Compara los <code>count</code> primeros bytes en los arreglos <code>a</code> y <code>b</code>.
     * @param a     El primer arreglo a comparar.
     * @param b     El segundo arreglo a comparar.
     * @param count Cuántos bytes se deben comparar.
     * @return <code>true</code> si los <code>count</code> primeros bytes en los arreglos <code>a</code> y <code>b</code> son iguales.
     */
    public static boolean arrayequals(byte[] a, byte[] b, int count) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length < count || b.length < count) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        byte[] array1 = {1, 2, 3, 4, 5};
        byte[] array2 = {1, 2, 3, 4, 5};
        byte[] array3 = {1, 2, 3, 4, 6};

        System.out.println(arrayequals(array1, array2, 5)); // true
        System.out.println(arrayequals(array1, array3, 5)); // false
        System.out.println(arrayequals(array1, array2, 3)); // true
        System.out.println(arrayequals(array1, array3, 3)); // true
    }
}