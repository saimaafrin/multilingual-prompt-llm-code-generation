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
        
        int delimiterIndex = toSplit.indexOf(delimiter);
        
        if (delimiterIndex == -1) {
            return null;
        }
        
        String[] result = new String[2];
        result[0] = toSplit.substring(0, delimiterIndex);
        result[1] = toSplit.substring(delimiterIndex + delimiter.length());
        
        return result;
    }
}