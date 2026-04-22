import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

private void addReverse(final File[] files) {
    List<File> fileList = new ArrayList<>();
    Collections.addAll(fileList, files);
    Collections.reverse(fileList);

    try (FileOutputStream outputStream = new FileOutputStream("output.txt", true)) {
        for (File file : fileList) {
            try (FileInputStream inputStream = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}