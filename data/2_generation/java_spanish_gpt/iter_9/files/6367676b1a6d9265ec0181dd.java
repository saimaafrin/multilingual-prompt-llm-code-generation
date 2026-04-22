public class SubstringCounter {

    /** 
     * Devuelve el número de ocurrencias de la subcadena {@code sub} en la cadena {@code str}.
     * @param str cadena en la que buscar. Devuelve 0 si es nula.
     * @param sub cadena a buscar. Devuelve 0 si es nula.
     * @return el número de ocurrencias de la subcadena {@code sub} en la cadena {@code str}.
     */
    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null) {
            return 0;
        }
        
        int count = 0;
        int index = 0;
        
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        
        return count;
    }

    public static void main(String[] args) {
        String str = "hello world, hello universe";
        String sub = "hello";
        int occurrences = countOccurrencesOf(str, sub);
        System.out.println("Occurrences of '" + sub + "': " + occurrences);
    }
}