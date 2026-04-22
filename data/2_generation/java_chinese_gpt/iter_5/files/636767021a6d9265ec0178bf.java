import java.lang.reflect.Method;

public class Converter {

    /**
     * <p>将输入对象转换为 java.lang.Character。</p>
     * @param type 要转换为的目标数据类型。
     * @param value 要转换的输入值。
     * @return 转换后的值。
     * @throws Exception 如果无法成功执行转换则抛出异常。
     * @since 1.8.0
     */
    @Override
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (type == Character.class) {
            if (value instanceof String) {
                String strValue = (String) value;
                if (strValue.length() == 1) {
                    return strValue.charAt(0);
                } else {
                    throw new Exception("String must be of length 1 to convert to Character.");
                }
            } else if (value instanceof Character) {
                return value;
            } else {
                throw new Exception("Unsupported type for conversion to Character.");
            }
        }
        throw new Exception("Unsupported target type: " + type.getName());
    }
}