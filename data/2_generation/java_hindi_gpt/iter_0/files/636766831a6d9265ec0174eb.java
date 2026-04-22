import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileReverser {

    /** 
     * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<File> fileList = List.of(files);
        Collections.reverse(fileList);

        StringBuilder contentBuilder = new StringBuilder();
        for (File file : fileList) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                for (String line : lines) {
                    contentBuilder.append(line).append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(contentBuilder.toString());
    }
}