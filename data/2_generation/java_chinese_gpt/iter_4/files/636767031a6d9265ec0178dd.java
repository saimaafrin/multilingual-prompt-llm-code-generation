public class Request {
    private byte[] content;

    public Request(byte[] content) {
        this.content = content;
    }

    /** 
     * 获取请求的内容长度。
     * @return 请求的内容长度。
     * @since 1.3
     */
    public long contentLength() {
        return content != null ? content.length : 0;
    }

    public static void main(String[] args) {
        Request request = new Request("Hello, World!".getBytes());
        System.out.println("Content Length: " + request.contentLength());
    }
}