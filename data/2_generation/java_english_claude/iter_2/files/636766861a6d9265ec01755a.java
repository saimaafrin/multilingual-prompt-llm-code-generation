import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {
    private final Pattern pattern;
    
    public UriMatcher(String template) {
        // Convert template to regex pattern
        String regex = template.replaceAll("\\{[^/]+\\}", "([^/]+)");
        this.pattern = Pattern.compile(regex);
    }

    /**
     * Match a URI against the pattern.
     * @param uri the uri to match against the template.
     * @return the match result, otherwise null if no match occurs.
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

    public static class MatchResult {
        private final String[] groups;
        
        public MatchResult(String[] groups) {
            this.groups = groups;
        }
        
        public String group(int index) {
            return groups[index];
        }
        
        public int groupCount() {
            return groups.length;
        }
    }
}