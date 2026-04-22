import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class URIMatcher {
    private final Pattern pattern;
    
    public URIMatcher(String pattern) {
        this.pattern = Pattern.compile(pattern);
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

        return matcher.toMatchResult();
    }
}