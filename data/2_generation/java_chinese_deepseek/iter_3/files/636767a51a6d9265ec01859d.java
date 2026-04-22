import java.util.Arrays;

public class ArrayComparator {

    /**
     * 如果内部数组的内容与提供的数组匹配，则返回真。
     *
     * @param data 提供的数组
     * @param offset 内部数组的起始偏移量
     * @param len 要比较的长度
     * @return 如果内部数组的内容与提供的数组匹配，则返回真
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        // 假设内部数组为 internalData
        byte[] internalData = getInternalData(); // 假设这是一个获取内部数组的方法

        // 检查边界条件
        if (offset < 0 || len < 0 || offset + len > internalData.length || len > data.length) {
            return false;
        }

        // 比较数组内容
        for (int i = 0; i < len; i++) {
            if (internalData[offset + i] != data[i]) {
                return false;
            }
        }

        return true;
    }

    // 假设这是一个获取内部数组的方法
    private byte[] getInternalData() {
        // 这里返回一个示例内部数组
        return new byte[] {1, 2, 3, 4, 5};
    }

    public static void main(String[] args) {
        ArrayComparator comparator = new ArrayComparator();
        byte[] data = {2, 3, 4};
        boolean result = comparator.equals(data, 1, 3);
        System.out.println(result); // 输出 true
    }
}