import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {

    private final Pattern pattern;
    
    public UriMatcher(String pattern) {
        this.pattern = Pattern.compile(pattern);
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
        private final String matchedUri;
        private final String[] groups;
        
        public MatchResult(String matchedUri, String[] groups) {
            this.matchedUri = matchedUri;
            this.groups = groups;
        }
        
        public String getMatchedUri() {
            return matchedUri;
        }
        
        public String[] getGroups() {
            return groups.clone();
        }
    }
}