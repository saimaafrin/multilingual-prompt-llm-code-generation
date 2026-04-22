import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class URIMatcher {
    private Pattern pattern;
    
    public URIMatcher(String uriPattern) {
        // Convert URI pattern to regex pattern
        String regex = uriPattern
            .replaceAll("\\*\\*", ".*")  // ** matches anything
            .replaceAll("\\*", "[^/]*")  // * matches anything except /
            .replaceAll("\\?", ".");     // ? matches single character
        pattern = Pattern.compile(regex);
    }

    /**
     * 将URI与模式进行匹配。
     * @param uri 要与模板匹配的URI。
     * @return 匹配结果，如果没有匹配则返回空。
     */
    public final MatchResult match(CharSequence uri) {
        if (uri == null) {
            return null;
        }

        Matcher matcher = pattern.matcher(uri);
        if (!matcher.matches()) {
            return null;
        }

        return new MatchResult() {
            @Override
            public String getMatch() {
                return matcher.group();
            }

            @Override
            public int start() {
                return matcher.start();
            }

            @Override
            public int end() {
                return matcher.end();
            }
        };
    }
}

interface MatchResult {
    String getMatch();
    int start();
    int end();
}