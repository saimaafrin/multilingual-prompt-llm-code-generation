import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    /**
     * <p>对<code>String</code>中找到的任何Java字面量进行反转义。例如，它将把一系列<code>'\'</code>和<code>'n'</code>转换为换行符，除非<code>'\'</code>前面有另一个<code>'\'</code>。</p>
     * @param str 要反转义的<code>String</code>，可以为空
     * @return 一个新的反转义<code>String</code>，如果输入字符串为空，则返回<code>null</code>
     */
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }
        
        // 初始化转义字符映射
        Map<String, String> escapeMap = new HashMap<>();
        escapeMap.put("\\n", "\n");  // 换行
        escapeMap.put("\\r", "\r");  // 回车
        escapeMap.put("\\t", "\t");  // 制表符
        escapeMap.put("\\b", "\b");  // 退格
        escapeMap.put("\\f", "\f");  // 换页
        escapeMap.put("\\\"", "\""); // 双引号
        escapeMap.put("\\'", "'");   // 单引号
        escapeMap.put("\\\\", "\\"); // 反斜杠
        
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '\\' && i + 1 < str.length()) {
                // 检查是否是转义序列
                String escape = str.substring(i, Math.min(i + 2, str.length()));
                String mapped = escapeMap.get(escape);
                
                if (mapped != null) {
                    // 找到转义字符,添加映射后的字符
                    result.append(mapped);
                    i++;  // 跳过下一个字符
                } else {
                    // 不是已知的转义序列,保持原样
                    result.append(ch);
                }
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}