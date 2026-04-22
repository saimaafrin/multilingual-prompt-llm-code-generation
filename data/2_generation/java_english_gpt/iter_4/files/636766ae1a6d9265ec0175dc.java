public class HttpResponseChecker {

    private int responseCode;

    public HttpResponseChecker(int responseCode) {
        this.responseCode = responseCode;
    }

    /** 
     * Check if the actual response is a Partial Content (HTTP 206 code)
     * @return is partial content or not
     */
    public Boolean isPartialContentResponse() {
        return responseCode == 206;
    }

    public static void main(String[] args) {
        HttpResponseChecker checker = new HttpResponseChecker(206);
        System.out.println("Is Partial Content Response: " + checker.isPartialContentResponse());
        
        HttpResponseChecker checker2 = new HttpResponseChecker(200);
        System.out.println("Is Partial Content Response: " + checker2.isPartialContentResponse());
    }
}