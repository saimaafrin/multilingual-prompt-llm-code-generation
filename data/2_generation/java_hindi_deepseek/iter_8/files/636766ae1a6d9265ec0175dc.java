import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PartialContentChecker {

    /**
     * जांचें कि क्या वास्तविक प्रतिक्रिया आंशिक सामग्री (HTTP 206 कोड) है
     * @return आंशिक सामग्री है या नहीं
     */
    public Boolean isPartialContentResponse(ResponseEntity<?> response) {
        return response.getStatusCode() == HttpStatus.PARTIAL_CONTENT;
    }
}