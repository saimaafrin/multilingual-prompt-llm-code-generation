import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {

    private static final String URI_PATTERN = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";

    /**
     * Match a URI against the pattern.
     * @param uri the uri to match against the template.
     * @return the match result, otherwise null if no match occurs.
     */
    public static UriMatchResult matchUri(String uri) {
        if (uri == null) {
            return null;
        }

        Pattern pattern = Pattern.compile(URI_PATTERN);
        Matcher matcher = pattern.matcher(uri);

        if (!matcher.matches()) {
            return null;
        }

        String scheme = matcher.group(2);
        String authority = matcher.group(4);
        String path = matcher.group(5);
        String query = matcher.group(7);
        String fragment = matcher.group(9);

        return new UriMatchResult(scheme, authority, path, query, fragment);
    }
}

class UriMatchResult {
    private final String scheme;
    private final String authority; 
    private final String path;
    private final String query;
    private final String fragment;

    public UriMatchResult(String scheme, String authority, String path, String query, String fragment) {
        this.scheme = scheme;
        this.authority = authority;
        this.path = path;
        this.query = query;
        this.fragment = fragment;
    }

    public String getScheme() {
        return scheme;
    }

    public String getAuthority() {
        return authority;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }

    public String getFragment() {
        return fragment;
    }
}