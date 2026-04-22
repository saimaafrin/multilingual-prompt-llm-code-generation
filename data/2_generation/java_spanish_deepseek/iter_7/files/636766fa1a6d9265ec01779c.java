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

    try {
        // Leer caracteres hasta encontrar un terminador
        while ((currentChar = System.in.read()) != -1) {
            char ch = (char) currentChar;
            if (terminatorSet.contains(ch)) {
                break; // Terminar si se encuentra un terminador
            }
            token.append(ch);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return token.toString();
}