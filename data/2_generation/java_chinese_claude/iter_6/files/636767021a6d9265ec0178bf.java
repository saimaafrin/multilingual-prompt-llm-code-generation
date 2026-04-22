import java.util.Objects;

public class CharacterConverter {

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
        if (value == null) {
            return null;
        }

        if (value instanceof Character) {
            return value;
        }

        if (value instanceof String) {
            String str = (String) value;
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new Exception("Cannot convert String with length > 1 to Character: " + str);
        }

        if (value instanceof Number) {
            int intValue = ((Number) value).intValue();
            if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
                return Character.valueOf((char) intValue);
            }
            throw new Exception("Cannot convert Number outside char range: " + intValue);
        }

        throw new Exception("Cannot convert value of type " + value.getClass().getName() + " to Character");
    }
}