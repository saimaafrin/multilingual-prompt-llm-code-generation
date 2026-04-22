import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileReverser {

    /** 
     * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        Arrays.sort(files, (f1, f2) -> f2.getName().compareTo(f1.getName())); // Sort files in reverse order

        for (File file : files) {
            try {
                String content = new String(Files.readAllBytes(file.toPath()));
                Files.write(new File("output.txt").toPath(), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}