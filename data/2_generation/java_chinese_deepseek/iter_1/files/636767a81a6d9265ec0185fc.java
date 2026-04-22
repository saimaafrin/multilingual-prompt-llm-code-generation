import java.io.IOException;
import java.io.InputStream;

public class ProtocolParser {
    private InputStream inputStream;

    public ProtocolParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 尝试读取一个字段标签，如果到达文件末尾则返回零。协议消息解析器使用此方法读取标签，因为协议消息可以合法地在任何标签出现的地方结束，而零不是有效的标签编号。
     */
    public int readTag() throws IOException {
        int tag = inputStream.read();
        if (tag == -1) {
            return 0; // 到达文件末尾，返回0
        }
        return tag;
    }
}