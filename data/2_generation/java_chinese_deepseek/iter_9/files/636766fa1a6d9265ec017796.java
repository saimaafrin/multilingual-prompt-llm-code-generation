import java.util.Objects;

public class BooleanArrayConverter {

    /**
     * <p>将基本数据类型的 boolean 数组转换为对象。</p> <p>对于输入数组 <code>null</code>，此方法返回 <code>null</code>。</p>
     * @param array  一个 <code>boolean</code> 数组
     * @return 一个 <code>Boolean</code> 数组，如果输入数组为空则返回 <code>null</code>
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        }
        Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[] testArray = {true, false, true};
        Boolean[] result = toObject(testArray);
        for (Boolean b : result) {
            System.out.println(b);
        }
    }
}