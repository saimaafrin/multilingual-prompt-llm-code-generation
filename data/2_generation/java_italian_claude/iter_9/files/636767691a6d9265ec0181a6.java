public class StringSplitter {
    /**
     * Divide una Stringa alla prima occorrenza del delimitatore. Non include il delimitatore nel risultato.
     * @param toSplit la stringa da dividere
     * @param delimiter il delimitatore con cui dividere la stringa
     * @return un array di due elementi con l'indice 0 che rappresenta la parte prima del delimitatore, e l'indice 1 che rappresenta la parte dopo il delimitatore (nessun elemento include il delimitatore); oppure <code>null</code> se il delimitatore non è stato trovato nella Stringa di input fornita
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