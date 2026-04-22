import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PartialContentChecker {

    /**
     * Check if the actual response is a Partial Content (HTTP 206 code)
     * @return is partial content or not
     */
    public Boolean isPartialContentResponse(ResponseEntity<?> response) {
        return response.getStatusCode() == HttpStatus.PARTIAL_CONTENT;
    }
}