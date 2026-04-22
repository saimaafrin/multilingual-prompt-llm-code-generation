import java.lang.Character;

public class Converter {

    /**
     * <p>Convierte el objeto de entrada en un java.lang.Character.</p>
     * @param type Tipo de dato al que este valor debe ser convertido.
     * @param value El valor de entrada que se va a convertir.
     * @return El valor convertido.
     * @throws Exception si la conversión no se puede realizar con éxito.
     * @since 1.8.0
     */
    @Override 
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (type == Character.class) {
            if (value instanceof String && ((String) value).length() == 1) {
                return ((String) value).charAt(0);
            } else if (value instanceof Character) {
                return value;
            } else {
                throw new Exception("Cannot convert value to Character");
            }
        }
        throw new Exception("Unsupported type: " + type.getName());
    }
}