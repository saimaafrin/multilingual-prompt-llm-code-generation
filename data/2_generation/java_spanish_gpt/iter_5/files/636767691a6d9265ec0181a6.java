public class StringSplitter {
    
    /** 
     * Divide una cadena en la primera ocurrencia del delimitador. No incluye el delimitador en el resultado.
     * @param toSplit la cadena a dividir
     * @param delimiter el delimitador para dividir la cadena
     * @return un array de dos elementos donde el índice 0 es antes del delimitador, y el índice 1 es después del delimitador (ninguno de los elementos incluye el delimitador); o <code>null</code> si no se encontró el delimitador en la cadena de entrada dada
     */
    public static String[] split(String toSplit, String delimiter) {
        if (toSplit == null || delimiter == null) {
            return null;
        }
        
        int index = toSplit.indexOf(delimiter);
        if (index == -1) {
            return null;
        }
        
        String beforeDelimiter = toSplit.substring(0, index);
        String afterDelimiter = toSplit.substring(index + delimiter.length());
        
        return new String[] { beforeDelimiter, afterDelimiter };
    }

    public static void main(String[] args) {
        String[] result = split("Hello,World", ",");
        if (result != null) {
            System.out.println("Before delimiter: " + result[0]);
            System.out.println("After delimiter: " + result[1]);
        } else {
            System.out.println("Delimiter not found.");
        }
    }
}