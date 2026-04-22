public class Request {
    private long contentLength;

    public Request(long contentLength) {
        this.contentLength = contentLength;
    }

    /** 
     * Recupera la longitud del contenido de la solicitud.
     * @return La longitud del contenido de la solicitud.
     * @since 1.3
     */
    public long contentLength() {
        return contentLength;
    }

    public static void main(String[] args) {
        Request request = new Request(1024);
        System.out.println("La longitud del contenido de la solicitud es: " + request.contentLength());
    }
}