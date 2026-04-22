import javax.servlet.http.HttpServletRequest;

public class RequestWrapper {
    private HttpServletRequest request;

    /**
     * 获取请求的内容长度。
     * @return 请求的内容长度。
     * @since 1.3
     */
    public long contentLength() {
        long length = request.getContentLengthLong();
        if (length < 0) {
            length = 0L;
        }
        return length;
    }
}