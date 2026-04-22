import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PartialContentChecker {

    /**
     * Controlla se la risposta attuale è un Contenuto Parziale (codice HTTP 206)
     * @return vero se è contenuto parziale, falso altrimenti
     */
    public Boolean isPartialContentResponse(ResponseEntity<?> response) {
        return response.getStatusCode() == HttpStatus.PARTIAL_CONTENT;
    }
}