import java.io.IOException;
import java.io.DataInputStream;

public class DataReader {
    private DataInputStream in;
    
    public DataReader(DataInputStream in) {
        this.in = in;
    }

    /**
     * 从流中读取 {@code string} 字段值。
     */
    @Override
    public String readString() throws IOException {
        // 首先读取字符串长度
        int length = in.readInt();
        
        // 如果长度为-1,表示null值
        if (length == -1) {
            return null;
        }
        
        // 创建byte数组来存储字符串数据
        byte[] bytes = new byte[length];
        
        // 从流中读取字符串数据
        in.readFully(bytes);
        
        // 将byte数组转换为字符串并返回
        return new String(bytes, "UTF-8");
    }
}