import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
 */
private void addReverse(final InputStream[] files) {
    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        // Reverse the order of files
        for (int i = files.length - 1; i >= 0; i--) {
            InputStream file = files[i];
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = file.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            file.close();
        }
        
        // Output the result (for example, to System.out)
        System.out.write(outputStream.toByteArray());
        outputStream.close();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}