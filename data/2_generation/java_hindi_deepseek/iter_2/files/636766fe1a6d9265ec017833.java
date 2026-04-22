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

        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void deleteDirectoryOnExit(File directory) throws IOException {
        if (!directory.exists()) {
            return;
        }

        if (!directory.isDirectory()) {
            throw new IOException("Not a directory: " + directory);
        }

        File[] files = directory.listFiles();
        if (files == null) {
            throw new IOException("Failed to list contents of " + directory);
        }

        for (File file : files) {
            if (file.isDirectory()) {
                deleteDirectoryOnExit(file);
            } else {
                file.deleteOnExit();
            }
        }

        directory.deleteOnExit();
    }
}