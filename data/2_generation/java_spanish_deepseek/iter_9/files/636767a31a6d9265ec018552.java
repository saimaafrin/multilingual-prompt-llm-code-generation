import java.io.IOException;
import java.io.DataInput;

public class DataReader {

    private DataInput input;

    public DataReader(DataInput input) {
        this.input = input;
    }

    /**
     * Lee el valor de un campo de tipo {@code string} del flujo.
     * 
     * @return el valor del campo de tipo {@code string} leído del flujo.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    @Override
    public String readString() throws IOException {
        return input.readUTF();
    }
}