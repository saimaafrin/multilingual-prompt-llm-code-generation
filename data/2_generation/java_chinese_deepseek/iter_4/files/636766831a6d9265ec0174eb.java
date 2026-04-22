import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {

    private List<File> fileList = new ArrayList<>();

    /**
     * 以逆序添加指定的文件。
     */
    private void addReverse(final File[] files) {
        if (files == null) {
            return;
        }
        
        // 将数组转换为列表
        List<File> tempList = new ArrayList<>();
        for (File file : files) {
            tempList.add(file);
        }
        
        // 反转列表
        Collections.reverse(tempList);
        
        // 添加到成员变量中
        fileList.addAll(tempList);
    }
}