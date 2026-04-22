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

        // Convert pattern to regex by escaping special chars and replacing wildcards
        String regex = pattern.replaceAll("([.+?^${}()|\\[\\]\\\\])", "\\\\$1")
                             .replace("*", ".*")
                             .replace("?", ".");
        
        // Add start and end anchors
        regex = "^" + regex + "$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(uri);

        if (m.matches()) {
            return m.group(0);
        }

        return null;
    }
}