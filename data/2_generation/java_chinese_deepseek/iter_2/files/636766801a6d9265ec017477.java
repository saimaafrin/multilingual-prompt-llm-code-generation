import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReverser {

    /**
     * 以逆序添加指定的文件。
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<byte[]> fileContents = new ArrayList<>();

        // 读取所有文件内容
        for (InputStream file : files) {
            try (ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
                int nRead;
                byte[] data = new byte[1024];
                while ((nRead = file.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();
                fileContents.add(buffer.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 逆序文件内容
        Collections.reverse(fileContents);

        // 处理逆序后的文件内容（例如写入到输出流或其他操作）
        for (byte[] content : fileContents) {
            // 这里可以根据需要处理逆序后的文件内容
            // 例如：System.out.write(content);
        }
    }
}