import java.io.IOException;
import java.io.DataInput;

public class MyReader {
    private DataInput input;

    public MyReader(DataInput input) {
        this.input = input;
    }

    /**
     * Lee el valor de un campo de tipo {@code string} del flujo.
     */
    @Override
    public String readString() throws IOException {
        return input.readUTF();
    }
}