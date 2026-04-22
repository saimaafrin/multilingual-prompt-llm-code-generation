import javax.servlet.http.HttpServletResponse;

public class ResponseChecker {
    private HttpServletResponse response;
    
    public ResponseChecker(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * Controlla se la risposta attuale è un Contenuto Parziale (codice HTTP 206)
     * @return vero se è contenuto parziale, falso altrimenti
     */
    public Boolean isPartialContentResponse() {
        return response.getStatus() == HttpServletResponse.SC_PARTIAL_CONTENT;
    }
}