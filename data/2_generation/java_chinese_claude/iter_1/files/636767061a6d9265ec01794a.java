package org.apache.commons.io;

/**
 * Utility class for handling file operations.
 */
public class FilenameUtils {

    private static final char EXTENSION_SEPARATOR = '.';
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    /**
     * 返回最后一个扩展名分隔符（即点号）的索引。<p> 此方法还检查最后一个点后面是否没有目录分隔符。为此，它使用 {@link #indexOfLastSeparator(String)}，该方法可以处理Unix或Windows格式的文件。<p> 无论代码运行在哪台机器上，输出结果都是相同的。
     * @param filename 要查找最后一个路径分隔符的文件名，如果为空则返回-1
     * @return 最后一个分隔符的索引，如果没有这样的字符则返回-1
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int extensionPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        int lastSeparator = indexOfLastSeparator(filename);
        
        // 如果没找到点号，或者点号在最后一个路径分隔符之前，返回-1
        return (extensionPos > lastSeparator) ? extensionPos : -1;
    }
    
    /**
     * Returns the index of the last directory separator character.
     * @param filename The filename to find the last path separator in
     * @return The index of the last separator character, or -1 if there is no such character
     */
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}