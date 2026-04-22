public class BodyChecker {
    /**
     * Verdadero si el cuerpo es un arreglo de bytes
     * @return Verdadero si el cuerpo es un arreglo de bytes
     */
    public boolean hasBytes(Object body) {
        return body instanceof byte[];
    }
}