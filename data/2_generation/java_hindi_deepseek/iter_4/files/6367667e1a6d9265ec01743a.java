import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class FileLastWriteTime {

    /**
     * अंतिम बार, मिलीसेकंड में, एक लिखने की प्रक्रिया हुई थी।
     * @return यह
     */
    public long lastWriteTimeStampInMilliseconds() {
        File file = new File("example.txt"); // Replace with your file path
        try {
            BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            return attrs.lastModifiedTime().toMillis();
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // Return -1 in case of an error
        }
    }
}