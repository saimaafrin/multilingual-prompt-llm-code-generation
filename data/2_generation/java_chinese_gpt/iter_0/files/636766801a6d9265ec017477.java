import java.io.InputStream;
import java.util.Stack;

public class FileAdder {
    
    /** 
     * 以逆序添加指定的文件。
     */
    private void addReverse(final InputStream[] files) {
        Stack<InputStream> stack = new Stack<>();
        
        // 将所有文件压入栈中
        for (InputStream file : files) {
            stack.push(file);
        }
        
        // 逆序处理文件
        while (!stack.isEmpty()) {
            InputStream file = stack.pop();
            // 这里可以添加处理文件的逻辑
            processFile(file);
        }
    }
    
    private void processFile(InputStream file) {
        // 处理文件的逻辑
        // 例如，读取文件内容或将其添加到某个集合中
    }
}