import com.google.gson.JsonObject;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentBuilder {

    /**
     * 构建内容，如果包含 @ 某人，则设置 @ 信息。
     */
    private Map<String,Object> buildContent(JsonObject jsonObject) {
        Map<String,Object> content = new HashMap<>();
        
        if(jsonObject == null) {
            return content;
        }

        // 获取消息内容
        String text = jsonObject.has("text") ? jsonObject.get("text").getAsString() : "";
        content.put("text", text);

        // 解析@信息
        List<Map<String,String>> atList = new ArrayList<>();
        Pattern pattern = Pattern.compile("@([\\w\\-]+)");
        Matcher matcher = pattern.matcher(text);
        
        while(matcher.find()) {
            Map<String,String> atInfo = new HashMap<>();
            String username = matcher.group(1);
            atInfo.put("username", username);
            atList.add(atInfo);
        }

        if(!atList.isEmpty()) {
            content.put("at", atList);
        }

        return content;
    }
}