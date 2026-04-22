public class FileNameUtils {

    /**
     * 返回最后一个扩展名分隔符（即点号）的索引。<p> 此方法还检查最后一个点后面是否没有目录分隔符。为此，它使用 {@link #indexOfLastSeparator(String)}，该方法可以处理Unix或Windows格式的文件。<p> 无论代码运行在哪台机器上，输出结果都是相同的。
     * @param filename 要查找最后一个路径分隔符的文件名，如果为空则返回-1
     * @return 最后一个分隔符的索引，如果没有这样的字符则返回-1
     */
    public static int indexOfExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return -1;
        }

        int lastDotIndex = filename.lastIndexOf('.');
        int lastSeparatorIndex = indexOfLastSeparator(filename);

        // Check if the last dot is after the last separator
        if (lastDotIndex > lastSeparatorIndex) {
            return lastDotIndex;
        }

        return -1;
    }

    /**
     * 查找最后一个路径分隔符的索引，支持Unix和Windows格式。
     * @param path 要查找的路径
     * @return 最后一个分隔符的索引，如果没有找到则返回-1
     */
    private static int indexOfLastSeparator(String path) {
        if (path == null || path.isEmpty()) {
            return -1;
        }

        int lastUnixSeparator = path.lastIndexOf('/');
        int lastWindowsSeparator = path.lastIndexOf('\\');

        return Math.max(lastUnixSeparator, lastWindowsSeparator);
    }

    public static void main(String[] args) {
        // 测试示例
        System.out.println(indexOfExtension("example.txt")); // 输出: 7
        System.out.println(indexOfExtension("folder/example.txt")); // 输出: 14
        System.out.println(indexOfExtension("folder/example")); // 输出: -1
        System.out.println(indexOfExtension(null)); // 输出: -1
    }
}