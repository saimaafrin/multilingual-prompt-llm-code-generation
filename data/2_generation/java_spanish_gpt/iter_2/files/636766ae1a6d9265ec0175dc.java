public class HttpResponseChecker {

    private int statusCode;

    public HttpResponseChecker(int statusCode) {
        this.statusCode = statusCode;
    }

    /** 
     * Verifica si la respuesta actual es un Contenido Parcial (código HTTP 206)
     * @return verdadero si es contenido parcial, falso en caso contrario
     */
    public Boolean isPartialContentResponse() {
        return statusCode == 206;
    }

    public static void main(String[] args) {
        HttpResponseChecker responseChecker = new HttpResponseChecker(206);
        System.out.println("Is partial content response: " + responseChecker.isPartialContentResponse()); // Should print true

        responseChecker = new HttpResponseChecker(200);
        System.out.println("Is partial content response: " + responseChecker.isPartialContentResponse()); // Should print false
    }
}