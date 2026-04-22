public class HttpResponseChecker {

    private int statusCode;

    public HttpResponseChecker(int statusCode) {
        this.statusCode = statusCode;
    }

    /** 
     * जांचें कि क्या वास्तविक प्रतिक्रिया आंशिक सामग्री (HTTP 206 कोड) है
     * @return आंशिक सामग्री है या नहीं
     */
    public Boolean isPartialContentResponse() {
        return statusCode == 206;
    }

    public static void main(String[] args) {
        HttpResponseChecker responseChecker = new HttpResponseChecker(206);
        System.out.println("Is partial content response: " + responseChecker.isPartialContentResponse());
        
        HttpResponseChecker responseChecker2 = new HttpResponseChecker(200);
        System.out.println("Is partial content response: " + responseChecker2.isPartialContentResponse());
    }
}