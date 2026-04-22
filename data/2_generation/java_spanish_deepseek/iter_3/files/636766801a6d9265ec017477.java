import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileAdder {

    /**
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            for (int i = files.length - 1; i >= 0; i--) {
                InputStream file = files[i];
                if (file != null) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = file.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
            // Aquí puedes hacer algo con el contenido de outputStream, como guardarlo en un archivo o procesarlo.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (InputStream file : files) {
                if (file != null) {
                    try {
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}