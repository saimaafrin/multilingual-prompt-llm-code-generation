import java.io.File;
import java.io.IOException;

public class FileDeleter {

    /**
     * जब JVM समाप्त होता है, तो एक फ़ाइल को हटाने के लिए शेड्यूल करता है। यदि फ़ाइल एक निर्देशिका है, तो इसे और सभी उप-निर्देशिकाओं को हटा दें।
     * @param file  हटाने के लिए फ़ाइल या निर्देशिका, {@code null} नहीं होनी चाहिए
     * @throws NullPointerException यदि फ़ाइल {@code null} है
     * @throws IOException यदि हटाना असफल हो जाता है
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File cannot be null");
        }

        // Schedule the file for deletion on JVM exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                deleteRecursively(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private static void deleteRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    deleteRecursively(subFile);
                }
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete file: " + file.getAbsolutePath());
        }
    }
}