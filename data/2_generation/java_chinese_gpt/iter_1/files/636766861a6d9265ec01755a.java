import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {
    private final String pattern;

    public UriMatcher(String pattern) {
        this.pattern = pattern;
    }

    /** 
     * 将URI与模式进行匹配。
     * @param uri 要与模板匹配的URI。
     * @return 匹配结果，如果没有匹配则返回空。
     */
    public final MatchResult match(CharSequence uri) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(uri);
        
        if (matcher.matches()) {
            return new MatchResult(matcher);
        } else {
            return null; // 返回空表示没有匹配
        }
    }

    public static class MatchResult {
        private final Matcher matcher;

        public MatchResult(Matcher matcher) {
            this.matcher = matcher;
        }

        public String group(int index) {
            return matcher.group(index);
        }

        public int groupCount() {
            return matcher.groupCount();
        }
    }

    public static void main(String[] args) {
        UriMatcher uriMatcher = new UriMatcher("^(http|https)://(www\\.)?example\\.com/(.*)$");
        MatchResult result = uriMatcher.match("https://www.example.com/path/to/resource");

        if (result != null) {
            System.out.println("Matched! Group count: " + result.groupCount());
            System.out.println("Group 0: " + result.group(0)); // Full match
            System.out.println("Group 1: " + result.group(1)); // Protocol
            System.out.println("Group 2: " + result.group(2)); // www.
            System.out.println("Group 3: " + result.group(3)); // Path
        } else {
            System.out.println("No match found.");
        }
    }
}