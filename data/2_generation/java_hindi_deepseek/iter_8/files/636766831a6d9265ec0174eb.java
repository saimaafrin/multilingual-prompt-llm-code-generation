import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class FileReverser {

    /**
     * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        Stack<String> stack = new Stack<>();

        // Read all files and push their content into the stack
        for (File file : files) {
            if (file.exists() && file.isFile()) {
                try (java.util.Scanner scanner = new java.util.Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        stack.push(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Write the content in reverse order to the last file
        File lastFile = files[files.length - 1];
        try (FileWriter writer = new FileWriter(lastFile, true)) {
            while (!stack.isEmpty()) {
                writer.write(stack.pop() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}