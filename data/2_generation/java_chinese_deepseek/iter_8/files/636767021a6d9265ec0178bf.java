import java.util.Objects;

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
    if (type != Character.class && type != char.class) {
        throw new IllegalArgumentException("目标类型必须是 Character 或 char");
    }

    if (value == null) {
        return null;
    }

    if (value instanceof Character) {
        return value;
    }

    if (value instanceof Number) {
        int intValue = ((Number) value).intValue();
        if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
            return (char) intValue;
        } else {
            throw new IllegalArgumentException("数值超出 Character 范围");
        }
    }

    if (value instanceof String) {
        String strValue = (String) value;
        if (strValue.length() == 1) {
            return strValue.charAt(0);
        } else {
            throw new IllegalArgumentException("字符串长度必须为 1");
        }
    }

    throw new IllegalArgumentException("无法将 " + value.getClass().getName() + " 转换为 Character");
}