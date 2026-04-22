public class ArrayLengthChecker {
    
    /** 
     * <p>Verifica si dos arreglos tienen la misma longitud, tratando los arreglos <code>null</code> como longitud <code>0</code>.</p>
     * @param array1 el primer arreglo, puede ser <code>null</code>
     * @param array2 el segundo arreglo, puede ser <code>null</code>
     * @return <code>true</code> si la longitud de los arreglos coincide, tratando <code>null</code> como un arreglo vacío
     */
    public static boolean isSameLength(final double[] array1, final double[] array2) {
        int length1 = (array1 == null) ? 0 : array1.length;
        int length2 = (array2 == null) ? 0 : array2.length;
        return length1 == length2;
    }

    public static void main(String[] args) {
        double[] arr1 = {1.0, 2.0, 3.0};
        double[] arr2 = {4.0, 5.0, 6.0};
        double[] arr3 = null;
        
        System.out.println(isSameLength(arr1, arr2)); // true
        System.out.println(isSameLength(arr1, arr3)); // false
        System.out.println(isSameLength(arr3, arr3)); // true
    }
}