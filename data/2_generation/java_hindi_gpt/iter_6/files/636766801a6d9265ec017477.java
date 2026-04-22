import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FileMerger {

    /** 
     * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            for (int i = files.length - 1; i >= 0; i--) {
                InputStream inputStream = files[i];
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // The outputStream now contains the merged content in reverse order
        byte[] mergedContent = outputStream.toByteArray();
        // You can now use mergedContent as needed
    }
}