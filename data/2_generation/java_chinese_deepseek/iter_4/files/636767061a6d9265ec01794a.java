public class FileUtils {

    /**
     * 返回最后一个扩展名分隔符（即点号）的索引。<p> 此方法还检查最后一个点后面是否没有目录分隔符。为此，它使用 {@link #indexOfLastSeparator(String)}，该方法可以处理Unix或Windows格式的文件。<p> 无论代码运行在哪台机器上，输出结果都是相同的。
     * @param filename 要查找最后一个路径分隔符的文件名，如果为空则返回-1
     * @return 最后一个分隔符的索引，如果没有这样的字符则返回-1
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastSeparatorIndex = indexOfLastSeparator(filename);
        int extensionIndex = filename.lastIndexOf('.');

        if (lastSeparatorIndex > extensionIndex) {
            return -1;
        }

        return extensionIndex;
    }

    /**
     * 返回最后一个路径分隔符的索引。该方法可以处理Unix或Windows格式的文件。
     * @param filename 要查找最后一个路径分隔符的文件名，如果为空则返回-1
     * @return 最后一个分隔符的索引，如果没有这样的字符则返回-1
     */
    private static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');

        return Math.max(lastUnixPos, lastWindowsPos);
    }

    public static void main(String[] args) {
        String filename1 = "path/to/file.txt";
        String filename2 = "path\\to\\file.txt";
        String filename3 = "path/to/file";
        String filename4 = null;

        System.out.println(indexOfExtension(filename1)); // 输出: 12
        System.out.println(indexOfExtension(filename2)); // 输出: 12
        System.out.println(indexOfExtension(filename3)); // 输出: -1
        System.out.println(indexOfExtension(filename4)); // 输出: -1
    }
}