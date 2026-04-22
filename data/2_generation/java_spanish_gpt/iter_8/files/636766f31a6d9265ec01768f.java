public class ArrayCloner {
    
    /** 
     * <p>Clona un arreglo devolviendo un resultado con tipo convertido y manejando <code>null</code>.</p> 
     * <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  el arreglo a clonar, puede ser <code>null</code>
     * @return el arreglo clonado, <code>null</code> si la entrada es <code>null</code>
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        char[] clonedArray = new char[array.length];
        System.arraycopy(array, 0, clonedArray, 0, array.length);
        return clonedArray;
    }

    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c'};
        char[] cloned = clone(original);
        
        // Print the cloned array
        if (cloned != null) {
            for (char c : cloned) {
                System.out.print(c + " ");
            }
        } else {
            System.out.println("Cloned array is null");
        }
    }
}