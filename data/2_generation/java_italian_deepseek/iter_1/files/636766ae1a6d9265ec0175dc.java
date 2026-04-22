import java.net.HttpURLConnection;
import java.net.URL;

public class HttpResponseChecker {

    /**
     * Controlla se la risposta attuale è un Contenuto Parziale (codice HTTP 206)
     * @return vero se è contenuto parziale, falso altrimenti
     */
    public Boolean isPartialContentResponse(HttpURLConnection connection) {
        try {
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_PARTIAL;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            HttpResponseChecker checker = new HttpResponseChecker();
            boolean isPartialContent = checker.isPartialContentResponse(connection);
            System.out.println("Is Partial Content Response: " + isPartialContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}