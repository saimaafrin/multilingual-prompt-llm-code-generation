import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class FileReverser {

    /** 
     * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        // Create a StringBuilder to hold the content
        StringBuilder contentBuilder = new StringBuilder();

        // Reverse the array of files
        File[] reversedFiles = files.clone();
        Collections.reverse(java.util.Arrays.asList(reversedFiles));

        // Read each file in reverse order and append its content
        for (File file : reversedFiles) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                contentBuilder.append(content).append(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Output the combined content (for demonstration purposes)
        System.out.println(contentBuilder.toString());
    }

    public static void main(String[] args) {
        // Example usage
        FileReverser fileReverser = new FileReverser();
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        fileReverser.addReverse(files);
    }
}