import javax.servlet.http.HttpServletResponse;

public class ResponseUtils {
    
    /**
     * 检查实际响应是否为部分内容（HTTP 206 代码）
     * @return 是否为部分内容
     */
    public Boolean isPartialContentResponse() {
        return HttpServletResponse.SC_PARTIAL_CONTENT == 206;
    }
}