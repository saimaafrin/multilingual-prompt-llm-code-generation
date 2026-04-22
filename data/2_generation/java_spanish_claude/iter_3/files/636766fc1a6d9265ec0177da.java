public class ParameterParser {
    /**
     * Determina si un nombre de parámetro termina en la posición actual, es decir, si el carácter dado califica como un separador.
     * @param c Carácter a evaluar
     * @return true si el carácter es un separador válido, false en caso contrario
     */
    private static boolean esSeparadorDeParametro(final char c) {
        return Character.isWhitespace(c) || c == '=' || c == ',' || c == ';' || c == ')';
    }
}