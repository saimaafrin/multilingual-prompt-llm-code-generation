import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

private void addReverse(final File[] files) {
    if (files == null || files.length == 0) {
        return;
    }

    List<File> fileList = new ArrayList<>();
    Collections.addAll(fileList, files);
    Collections.reverse(fileList);

    try (FileWriter writer = new FileWriter("output.txt", true)) {
        for (File file : fileList) {
            writer.write(file.getName() + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}