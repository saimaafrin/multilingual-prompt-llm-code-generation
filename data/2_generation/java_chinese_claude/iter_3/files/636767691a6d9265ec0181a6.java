public class StringSplitter {
    /**
     * 在分隔符第一次出现的位置拆分字符串。结果中不包括分隔符。
     * @param toSplit 要拆分的字符串
     * @param delimiter 用于拆分字符串的分隔符
     * @return 一个包含两个元素的数组，索引0为分隔符之前的部分，索引1为分隔符之后的部分（两个元素均不包括分隔符）；如果在给定的输入字符串中未找到分隔符，则返回<code>null</code>
     */
    public static String[] split(String toSplit, String delimiter) {
        if (toSplit == null || delimiter == null) {
            return null;
        }
        
        int index = toSplit.indexOf(delimiter);
        if (index == -1) {
            return null;
        }
        
        String[] result = new String[2];
        result[0] = toSplit.substring(0, index);
        result[1] = toSplit.substring(index + delimiter.length());
        
        return result;
    }
}