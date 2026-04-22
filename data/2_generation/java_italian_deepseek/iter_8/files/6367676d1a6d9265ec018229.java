public class ArrayUtils {

    /**
     * Rimuove gli spazi bianchi dagli elementi dell'array di Stringhe fornito, chiamando <code>String.trim()</code> su ciascuno di essi.
     * @param array l'array di Stringhe originale
     * @return l'array risultante (della stessa dimensione) con elementi privati degli spazi bianchi
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
        for (String s : result) {
            System.out.println("'" + s + "'");
        }
    }
}