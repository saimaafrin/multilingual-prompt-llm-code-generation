import java.io.IOException;
import java.io.DataInput;

public class DataInputReader {

    private DataInput input;

    public DataInputReader(DataInput input) {
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