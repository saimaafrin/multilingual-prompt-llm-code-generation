import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

private void addReverse(final InputStream[] files) {
    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        // Read each file in reverse order
        for (int i = files.length - 1; i >= 0; i--) {
            InputStream inputStream = files[i];
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            inputStream.close();
        }
        
        // Output the combined content
        System.out.println(outputStream.toString());
        outputStream.close();
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}