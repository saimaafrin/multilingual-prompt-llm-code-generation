public class Request {
    private long contentLength;

    public Request(long contentLength) {
        this.contentLength = contentLength;
    }

    /** 
     * Retrieve the content length of the request.
     * @return The content length of the request.
     * @since 1.3
     */
    public long contentLength() {
        return contentLength;
    }

    public static void main(String[] args) {
        Request request = new Request(1024);
        System.out.println("Content Length: " + request.contentLength());
    }
}