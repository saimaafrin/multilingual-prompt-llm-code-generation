import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class UriMatcher {

    /**
     * Confronta un URI con il modello.
     * @param uri l'uri da confrontare con il template.
     * @return il risultato della corrispondenza, altrimenti null se non si verifica alcuna corrispondenza.
     */
    public final MatchResult match(CharSequence uri) {
        // Definisci il pattern del template (esempio: "/resource/{id}")
        String template = "/resource/\\d+"; // Esempio di pattern per un URI con un ID numerico
        Pattern pattern = Pattern.compile(template);
        Matcher matcher = pattern.matcher(uri);

        // Se c'è una corrispondenza, restituisci il risultato
        if (matcher.matches()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher();
        CharSequence uri = "/resource/123";
        MatchResult result = matcher.match(uri);

        if (result != null) {
            System.out.println("URI matches the template: " + result.group());
        } else {
            System.out.println("No match found.");
        }
    }
}