import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

        List<String> allLines = new ArrayList<>();

        // Read all lines from all files
        for (File file : files) {
            if (file.exists() && file.isFile()) {
                try (java.util.Scanner scanner = new java.util.Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        allLines.add(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Reverse the order of lines
        Collections.reverse(allLines);

        // Write the reversed lines back to the first file
        if (files[0].exists() && files[0].isFile()) {
            try (FileWriter writer = new FileWriter(files[0])) {
                for (String line : allLines) {
                    writer.write(line + System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}