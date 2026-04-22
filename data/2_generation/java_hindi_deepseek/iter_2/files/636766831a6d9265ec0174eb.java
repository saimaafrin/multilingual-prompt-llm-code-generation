import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

private void addReverse(final File[] files) {
    try {
        StringBuilder combinedContent = new StringBuilder();
        
        // Read each file in reverse order
        for (int i = files.length - 1; i >= 0; i--) {
            File file = files[i];
            if (file.exists() && file.isFile()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    combinedContent.append(scanner.nextLine()).append("\n");
                }
                scanner.close();
            }
        }
        
        // Write the combined content to a new file
        File outputFile = new File("combined_reverse.txt");
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(combinedContent.toString());
        }
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}