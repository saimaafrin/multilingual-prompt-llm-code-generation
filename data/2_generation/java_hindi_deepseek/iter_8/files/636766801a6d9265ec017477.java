import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * निर्दिष्ट फ़ाइलों को उल्टे क्रम में जोड़ें।
 */
private void addReverse(final InputStream[] files) {
    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        // Iterate over the files in reverse order
        for (int i = files.length - 1; i >= 0; i--) {
            InputStream inputStream = files[i];
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            // Read the content of the file and write it to the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            // Close the input stream
            inputStream.close();
        }
        
        // Convert the output stream to a byte array
        byte[] result = outputStream.toByteArray();
        
        // Close the output stream
        outputStream.close();
        
        // Use the result as needed (e.g., print it, return it, etc.)
        System.out.println(new String(result));
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}