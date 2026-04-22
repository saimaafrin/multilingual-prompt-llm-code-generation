import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {
    private final Pattern pattern;
    
    public UriMatcher(String template) {
        // Convert template to regex pattern
        String regex = template.replaceAll("\\{[^}]+\\}", "([^/]+)");
        this.pattern = Pattern.compile(regex);
    }

    /**
     * Confronta un URI con il modello.
     * @param uri l'uri da confrontare con il template.
     * @return il risultato della corrispondenza, altrimenti null se non si verifica alcuna corrispondenza.
     */
    public final MatchResult match(CharSequence uri) {
        if (uri == null) {
            return null;
        }

        Matcher matcher = pattern.matcher(uri);
        if (!matcher.matches()) {
            return null;
        }

        return matcher.toMatchResult();
    }
}