import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {

    /** 
     * 以逆序添加指定的文件。
     */
    private void addReverse(final InputStream[] files) {
        List<InputStream> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);
        Collections.reverse(fileList);
        
        for (InputStream file : fileList) {
            // Add your logic to handle the InputStream file
            // For example, you might want to read from the InputStream or store it somewhere
            System.out.println("Adding file: " + file);
        }
    }
}