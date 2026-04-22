public class HttpMessage {
    private byte[] body;
    
    /**
     * 如果主体是字节数组，则返回真
     * @return 如果主体是字节数组，则返回真
     */
    public boolean hasBytes() {
        return body != null && body.length > 0;
    }
    
    // Constructor and other methods omitted for brevity
}