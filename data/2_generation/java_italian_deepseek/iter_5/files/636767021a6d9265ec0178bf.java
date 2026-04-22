import java.util.Objects;

public class Converter {

    /**
     * <p>Converte l'oggetto di input in un java.lang.Character.</p>
     * @param type Il tipo di dato in cui questo valore dovrebbe essere convertito.
     * @param value Il valore di input da convertire.
     * @return Il valore convertito.
     * @throws Exception se la conversione non può essere eseguita con successo
     * @since 1.8.0
     */
    @Override
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (type == Character.class || type == char.class) {
            if (value == null) {
                throw new Exception("Il valore di input non può essere nullo per la conversione a Character.");
            }
            if (value instanceof Character) {
                return value;
            }
            if (value instanceof String) {
                String strValue = (String) value;
                if (strValue.length() == 1) {
                    return strValue.charAt(0);
                } else {
                    throw new Exception("La stringa deve contenere esattamente un carattere per la conversione a Character.");
                }
            }
            if (value instanceof Number) {
                int intValue = ((Number) value).intValue();
                if (intValue >= Character.MIN_VALUE && intValue <= Character.MAX_VALUE) {
                    return (char) intValue;
                } else {
                    throw new Exception("Il valore numerico non è valido per la conversione a Character.");
                }
            }
            throw new Exception("Tipo di dato non supportato per la conversione a Character.");
        }
        throw new Exception("Tipo di destinazione non supportato: " + type.getName());
    }
}