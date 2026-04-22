public class SeparadorParametro {

    /** 
     * Determina si un nombre de parámetro termina en la posición actual, es decir, si el carácter dado califica como un separador. 
     */
    private static boolean esSeparadorDeParametro(final char c) {
        // Definimos los caracteres que consideramos como separadores
        char[] separadores = {',', ';', ' ', '\t', '\n', '\r', '(', ')', '{', '}', '[', ']', '=', '&', '|', '<', '>', '!', '?'};
        
        // Verificamos si el carácter dado es un separador
        for (char separador : separadores) {
            if (c == separador) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        char testChar = ',';
        System.out.println("¿Es separador? " + esSeparadorDeParametro(testChar)); // Debería imprimir true
    }
}