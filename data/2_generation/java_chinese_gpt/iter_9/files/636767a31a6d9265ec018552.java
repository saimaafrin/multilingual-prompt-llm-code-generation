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
            System.out.println("请输入字符串:");
            String input = stringReader.readString();
            System.out.println("您输入的字符串是: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}