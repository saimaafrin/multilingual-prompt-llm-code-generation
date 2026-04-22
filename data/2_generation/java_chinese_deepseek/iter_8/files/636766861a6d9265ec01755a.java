import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class UriMatcher {

    /**
     * 将URI与模式进行匹配。
     * @param uri 要与模板匹配的URI。
     * @return 匹配结果，如果没有匹配则返回空。
     */
    public final MatchResult match(CharSequence uri) {
        // 假设模式是一个正则表达式，这里使用一个简单的示例模式
        String pattern = "^https?://([^/]+)(/.*)?$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(uri);

        if (matcher.find()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher();
        CharSequence uri = "https://example.com/path/to/resource";
        MatchResult result = matcher.match(uri);

        if (result != null) {
            System.out.println("Match found: " + result.group(0));
        } else {
            System.out.println("No match found.");
        }
    }
}