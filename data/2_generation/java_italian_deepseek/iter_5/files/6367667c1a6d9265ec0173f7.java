public class BodyChecker {
    /**
     * Restituisce true se il corpo è un array di byte
     * @return true se il corpo è un array di byte
     */
    public boolean hasBytes(Object body) {
        return body instanceof byte[];
    }
}