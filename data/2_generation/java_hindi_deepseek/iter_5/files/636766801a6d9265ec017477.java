import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReverser {

    /**
     * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
     */
    private void addReverse(final InputStream[] files) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        try {
            // Iterate over the files in reverse order
            for (int i = files.length - 1; i >= 0; i--) {
                InputStream file = files[i];
                byte[] buffer = new byte[1024];
                int bytesRead;
                
                // Read the file content and write to the output stream
                while ((bytesRead = file.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                
                // Close the current file
                file.close();
            }
            
            // Output the result (for example, to a file or console)
            System.out.write(outputStream.toByteArray());
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}