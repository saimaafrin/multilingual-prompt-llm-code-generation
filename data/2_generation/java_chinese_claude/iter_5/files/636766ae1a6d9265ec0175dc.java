import javax.servlet.http.HttpServletResponse;

public class ResponseUtils {
    
    /**
     * 检查实际响应是否为部分内容（HTTP 206 代码）
     * @return 是否为部分内容
     */
    public Boolean isPartialContentResponse() {
        HttpServletResponse response = getResponse(); // Assuming getResponse() exists
        return response.getStatus() == HttpServletResponse.SC_PARTIAL_CONTENT;
    }
    
    // Mock method to get response - implementation would depend on context
    private HttpServletResponse getResponse() {
        return null;
    }
}