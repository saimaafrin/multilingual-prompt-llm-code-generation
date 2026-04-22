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
        // 假设我们有一个预定义的模式，例如匹配路径中的数字
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(uri);

        if (matcher.find()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher();
        MatchResult result = matcher.match("example/123/path");

        if (result != null) {
            System.out.println("Match found: " + result.group());
        } else {
            System.out.println("No match found.");
        }
    }
}