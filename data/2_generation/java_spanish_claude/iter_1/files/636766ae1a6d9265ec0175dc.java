import javax.servlet.http.HttpServletResponse;

public class ResponseValidator {
    
    private HttpServletResponse response;
    
    public ResponseValidator(HttpServletResponse response) {
        this.response = response;
    }

    /** 
     * Verifica si la respuesta actual es un Contenido Parcial (código HTTP 206)
     * @return verdadero si es contenido parcial, falso en caso contrario
     */
    public Boolean isPartialContentResponse() {
        return response.getStatus() == HttpServletResponse.SC_PARTIAL_CONTENT;
    }
}