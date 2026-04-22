import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReader {

    private BufferedReader reader;

    public StringReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /** 
     * 从流中读取 {@code string} 字段值。
     */
    @Override 
    public String readString() throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) {
        StringReader stringReader = new StringReader();
        try {
            System.out.println("Please enter a string:");
            String input = stringReader.readString();
            System.out.println("You entered: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}