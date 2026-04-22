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
    
    // Helper method to get current response
    private HttpServletResponse getResponse() {
        // Implementation details would depend on your framework
        // This is just a placeholder
        return null;
    }
}