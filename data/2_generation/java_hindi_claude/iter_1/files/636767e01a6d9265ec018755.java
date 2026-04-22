import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentBuilder {

    /**
     * Build content, if it has @mentions set the mentions
     * @param content The raw content string
     * @return Processed content with mentions extracted
     */
    public String buildContent(String content) {
        if (content == null || content.isEmpty()) {
            return "";
        }

        // Pattern to match @mentions
        Pattern pattern = Pattern.compile("@(\\w+)");
        Matcher matcher = pattern.matcher(content);
        
        List<String> mentions = new ArrayList<>();
        
        // Find all @mentions
        while (matcher.find()) {
            mentions.add(matcher.group(1));
        }

        // If mentions found, process them
        if (!mentions.isEmpty()) {
            // Replace @mentions with proper formatting
            for (String mention : mentions) {
                content = content.replace("@" + mention, "<@" + mention + ">");
            }
        }

        return content;
    }
}