import java.util.Objects;

@Override
protected Object convertToType(final Class<?> type, final Object value) throws Exception {
    if (type == Character.class || type == char.class) {
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
                throw new Exception("Stringa di lunghezza diversa da 1 non può essere convertita in Character.");
            }
        }
        if (value instanceof Number) {
            int intValue = ((Number) value).intValue();
            if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
                return (char) intValue;
            } else {
                throw new Exception("Valore numerico fuori dal range di un Character.");
            }
        }
        throw new Exception("Tipo di dato non supportato per la conversione in Character.");
    }
    throw new Exception("Tipo di destinazione non supportato: " + type.getName());
}