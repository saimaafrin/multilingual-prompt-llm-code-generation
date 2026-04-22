public class Request {
    private String content;

    public Request(String content) {
        this.content = content;
    }

    /** 
     * Recupera la longitud del contenido de la solicitud.
     * @return La longitud del contenido de la solicitud.
     * @since 1.3
     */
    public long contentLength() {
        return content != null ? content.length() : 0;
    }

    public static void main(String[] args) {
        Request request = new Request("Este es el contenido de la solicitud.");
        System.out.println("Longitud del contenido: " + request.contentLength());
    }
}