import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReader {

    private BufferedReader reader;

    public StringReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /** 
     * Lee el valor de un campo de tipo {@code string} del flujo.
     */
    @Override 
    public String readString() throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) {
        StringReader stringReader = new StringReader();
        try {
            System.out.println("Introduce un string:");
            String input = stringReader.readString();
            System.out.println("Has introducido: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}