import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    // Convertir el arreglo de terminadores a un conjunto para búsqueda rápida
    Set<Character> terminatorSet = new HashSet<>();
    for (char c : terminators) {
        terminatorSet.add(c);
    }

    StringBuilder token = new StringBuilder();
    int currentChar;

    // Leer caracteres hasta encontrar un terminador
    while (true) {
        try {
            currentChar = System.in.read();
        } catch (java.io.IOException e) {
            throw new RuntimeException("Error reading input", e);
        }

        // Si se encuentra un terminador, terminar la lectura
        if (terminatorSet.contains((char) currentChar) || currentChar == -1) {
            break;
        }

        // Agregar el caracter al token
        token.append((char) currentChar);
    }

    return token.toString();
}