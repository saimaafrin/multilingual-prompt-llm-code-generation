public class StringArrayTrimmer {

    /**
     * Recorta los elementos del arreglo de Strings dado, llamando a <code>String.trim()</code> en cada uno de ellos.
     * @param array arreglo de Strings original
     * @return el arreglo resultante (del mismo tamaño) con elementos recortados
     */
    public static String[] trimArrayElements(String[] array) {
        if (array == null) {
            return null;
        }
        
        String[] trimmedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                trimmedArray[i] = array[i].trim();
            } else {
                trimmedArray[i] = null;
            }
        }
        return trimmedArray;
    }

    public static void main(String[] args) {
        String[] testArray = {"  hello ", "  world  ", null, "  java  "};
        String[] result = trimArrayElements(testArray);
        
        for (String str : result) {
            System.out.println("'" + str + "'");
        }
    }
}