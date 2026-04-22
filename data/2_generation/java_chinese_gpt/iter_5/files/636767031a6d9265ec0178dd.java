public class Request {
    private long contentLength;

    public Request(long contentLength) {
        this.contentLength = contentLength;
    }

    /** 
     * 获取请求的内容长度。
     * @return 请求的内容长度。
     * @since 1.3
     */
    public long contentLength() {
        return contentLength;
    }

    public static void main(String[] args) {
        Request request = new Request(1024);
        System.out.println("请求的内容长度: " + request.contentLength());
    }
}