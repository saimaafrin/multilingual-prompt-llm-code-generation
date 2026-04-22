public class HttpResponseChecker {

    private int statusCode;

    public HttpResponseChecker(int statusCode) {
        this.statusCode = statusCode;
    }

    /** 
     * 检查实际响应是否为部分内容（HTTP 206 代码）
     * @return 是否为部分内容
     */
    public Boolean isPartialContentResponse() {
        return statusCode == 206;
    }

    public static void main(String[] args) {
        HttpResponseChecker responseChecker = new HttpResponseChecker(206);
        System.out.println("Is partial content response: " + responseChecker.isPartialContentResponse());
    }
}