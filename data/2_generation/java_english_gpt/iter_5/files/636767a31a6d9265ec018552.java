import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReader {

    private BufferedReader reader;

    public StringReader(InputStreamReader inputStreamReader) {
        this.reader = new BufferedReader(inputStreamReader);
    }

    /** 
     * Read a  {@code string} field value from the stream.
     */
    @Override 
    public String readString() throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) {
        try {
            StringReader stringReader = new StringReader(new InputStreamReader(System.in));
            System.out.println("Enter a string:");
            String input = stringReader.readString();
            System.out.println("You entered: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}