import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReader {

    /**
     * Lee el valor de un campo de tipo {@code string} del flujo.
     */
    @Override 
    public String readString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese un string: ");
        return reader.readLine();
    }

    public static void main(String[] args) {
        StringReader stringReader = new StringReader();
        try {
            String input = stringReader.readString();
            System.out.println("Usted ingresó: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}