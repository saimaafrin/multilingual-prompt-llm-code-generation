import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReverser {

    private List<byte[]> fileContents;

    public FileReverser() {
        this.fileContents = new ArrayList<>();
    }

    /**
     * 以逆序添加指定的文件。
     */
    private void addReverse(final InputStream[] files) {
        for (int i = files.length - 1; i >= 0; i--) {
            try (InputStream inputStream = files[i]) {
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] data = new byte[1024];
                while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                fileContents.add(buffer.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<byte[]> getFileContents() {
        return Collections.unmodifiableList(fileContents);
    }
}