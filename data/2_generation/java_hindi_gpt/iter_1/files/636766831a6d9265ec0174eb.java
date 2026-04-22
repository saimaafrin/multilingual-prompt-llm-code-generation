import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileMerger {

    /** 
     * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        Arrays.sort(files, (f1, f2) -> f2.getName().compareTo(f1.getName())); // Sort files in reverse order

        File outputFile = new File("merged_output.txt");
        try {
            for (File file : files) {
                if (file.exists() && file.isFile()) {
                    byte[] content = Files.readAllBytes(file.toPath());
                    Files.write(outputFile.toPath(), content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}