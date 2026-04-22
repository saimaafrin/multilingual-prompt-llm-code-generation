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
        // 假设我们有一个预定义的模式，例如匹配以 "http://" 或 "https://" 开头的URI
        Pattern pattern = Pattern.compile("^(http|https)://.*");
        Matcher matcher = pattern.matcher(uri);

        if (matcher.matches()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher();
        CharSequence uri = "https://example.com";
        MatchResult result = matcher.match(uri);

        if (result != null) {
            System.out.println("URI matched: " + result.group());
        } else {
            System.out.println("No match found.");
        }
    }
}