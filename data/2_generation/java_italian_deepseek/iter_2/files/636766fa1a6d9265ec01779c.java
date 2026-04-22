import java.util.HashSet;
import java.util.Set;

private String parseToken(final char[] terminators) {
    StringBuilder token = new StringBuilder();
    Set<Character> terminatorSet = new HashSet<>();
    
    // Aggiungi tutti i caratteri terminatori al set per un accesso rapido
    for (char c : terminators) {
        terminatorSet.add(c);
    }
    
    // Simula l'input di un token (ad esempio, da un flusso di input)
    // In un'implementazione reale, questo sarebbe sostituito con la lettura effettiva da un flusso
    String input = "exampleToken;"; // Esempio di input
    for (int i = 0; i < input.length(); i++) {
        char currentChar = input.charAt(i);
        
        // Se il carattere corrente è un terminatore, interrompi la lettura
        if (terminatorSet.contains(currentChar)) {
            break;
        }
        
        // Altrimenti, aggiungi il carattere al token
        token.append(currentChar);
    }
    
    return token.toString();
}