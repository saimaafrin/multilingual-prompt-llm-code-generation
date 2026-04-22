import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

private void addReverse(final File[] files) {
    if (files == null || files.length == 0) {
        return;
    }

    List<String> allLines = new ArrayList<>();

    // Read all lines from files in reverse order
    for (int i = files.length - 1; i >= 0; i--) {
        File file = files[i];
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

    // Write all lines to a new file in reverse order
    File outputFile = new File("reversed_output.txt");
    try (FileWriter writer = new FileWriter(outputFile)) {
        Collections.reverse(allLines);
        for (String line : allLines) {
            writer.write(line + System.lineSeparator());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}