import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponseChecker {

    /**
     * Verifica si la respuesta actual es un Contenido Parcial (código HTTP 206)
     * @return verdadero si es contenido parcial, falso en caso contrario
     */
    public Boolean isPartialContentResponse(ResponseEntity<?> response) {
        return response.getStatusCode() == HttpStatus.PARTIAL_CONTENT;
    }
}