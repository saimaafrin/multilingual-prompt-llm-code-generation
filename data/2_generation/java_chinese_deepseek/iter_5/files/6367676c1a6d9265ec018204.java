import java.util.ArrayList;
import java.util.List;

public class StringArrayConcatenator {

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        // 如果两个数组都为null，返回null
        if (array1 == null && array2 == null) {
            return null;
        }

        // 创建一个List来存储结果
        List<String> resultList = new ArrayList<>();

        // 如果array1不为null，将其元素添加到结果List中
        if (array1 != null) {
            for (String element : array1) {
                resultList.add(element);
            }
        }

        // 如果array2不为null，将其元素添加到结果List中
        if (array2 != null) {
            for (String element : array2) {
                resultList.add(element);
            }
        }

        // 将List转换为数组并返回
        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // 测试用例
        String[] array1 = {"a", "b", "c"};
        String[] array2 = {"d", "e", "f"};
        String[] result = concatenateStringArrays(array1, array2);

        // 输出结果
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}