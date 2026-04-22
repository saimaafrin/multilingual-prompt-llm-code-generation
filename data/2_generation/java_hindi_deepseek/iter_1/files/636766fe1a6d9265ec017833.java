import java.io.File;
import java.io.IOException;

public class FileUtils {

    /**
     * जब JVM समाप्त होता है, तो एक फ़ाइल को हटाने के लिए शेड्यूल करता है। यदि फ़ाइल एक निर्देशिका है, तो इसे और सभी उप-निर्देशिकाओं को हटा दें।
     * @param file  हटाने के लिए फ़ाइल या निर्देशिका, {@code null} नहीं होनी चाहिए
     * @throws NullPointerException यदि फ़ाइल {@code null} है
     * @throws IOException यदि हटाना असफल हो जाता है
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }

        file.deleteOnExit();

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    forceDeleteOnExit(subFile);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file_or_directory");
            forceDeleteOnExit(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}