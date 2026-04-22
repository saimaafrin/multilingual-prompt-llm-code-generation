import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReverseAdder {

    /**
     * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
     * 
     * @param files जोड़ने के लिए फ़ाइलों की सरणी
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<String> allLines = new ArrayList<>();

        // सभी फ़ाइलों से पंक्तियों को पढ़ें और सूची में जोड़ें
        for (File file : files) {
            if (file.exists() && file.isFile()) {
                try {
                    List<String> lines = java.nio.file.Files.readAllLines(file.toPath());
                    allLines.addAll(lines);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // पंक्तियों को उल्टे क्रम में करें
        Collections.reverse(allLines);

        // उल्टे क्रम में पंक्तियों को एक नई फ़ाइल में लिखें
        File outputFile = new File("reversed_output.txt");
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String line : allLines) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // उदाहरण उपयोग
        File[] files = { new File("file1.txt"), new File("file2.txt") };
        FileReverseAdder adder = new FileReverseAdder();
        adder.addReverse(files);
    }
}