import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {

    private List<byte[]> fileDataList = new ArrayList<>();

    /**
     * 以逆序添加指定的文件。
     */
    private void addReverse(final InputStream[] files) {
        if (files == null) {
            return;
        }

        // 读取每个文件的内容并存储到列表中
        for (InputStream file : files) {
            if (file != null) {
                try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
                    int nRead;
                    byte[] data = new byte[1024];
                    while ((nRead = file.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, nRead);
                    }
                    buffer.flush();
                    fileDataList.add(buffer.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 将列表逆序
        Collections.reverse(fileDataList);
    }

    // 其他方法...
}