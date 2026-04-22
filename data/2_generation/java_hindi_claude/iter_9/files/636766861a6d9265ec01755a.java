import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {

    private String pattern;

    public UriMatcher(String pattern) {
        this.pattern = pattern;
    }

    /** 
     * Match a URI against the pattern.
     * @param uri the uri to match against the template.
     * @return the match result, otherwise null if no match occurs.
     */
    public String match(String uri) {
        if (uri == null) {
            return null;
        }

        // Convert pattern to regex
        String regex = pattern.replaceAll("\\*", ".*")
                            .replaceAll("\\?", ".")
                            .replaceAll("\\{([^}]+)\\}", "([^/]+)");
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(uri);

        if (m.matches()) {
            // Return the first group if there is one, otherwise return the full match
            return m.groupCount() > 0 ? m.group(1) : m.group();
        }

        return null;
    }
}