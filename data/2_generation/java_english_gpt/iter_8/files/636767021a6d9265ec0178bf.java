import java.lang.Character;

public class Converter {

    /**
     * <p>Convert the input object into a java.lang.Character.</p>
     * @param type Data type to which this value should be converted.
     * @param value The input value to be converted.
     * @return The converted value.
     * @throws Exception if conversion cannot be performed successfully
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
        throw new Exception("Conversion to the specified type is not supported.");
    }
}