import java.util.Objects;

/**
 * Convierte el objeto de entrada en un java.lang.Character.
 * @param type Tipo de dato al que este valor debe ser convertido.
 * @param value El valor de entrada que se va a convertir.
 * @return El valor convertido.
 * @throws Exception si la conversión no se puede realizar con éxito.
 * @since 1.8.0
 */
@Override
protected Object convertToType(final Class<?> type, final Object value) throws Exception {
    if (type != Character.class && type != char.class) {
        throw new Exception("El tipo de destino no es Character o char.");
    }

    if (value == null) {
        return null;
    }

    if (value instanceof Character) {
        return value;
    }

    if (value instanceof String) {
        String strValue = (String) value;
        if (strValue.length() == 1) {
            return strValue.charAt(0);
        } else {
            throw new Exception("El valor String debe tener exactamente un carácter.");
        }
    }

    if (value instanceof Number) {
        int intValue = ((Number) value).intValue();
        if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
            return (char) intValue;
        } else {
            throw new Exception("El valor numérico está fuera del rango de un carácter.");
        }
    }

    throw new Exception("No se puede convertir el valor a Character: " + value.getClass().getName());
}