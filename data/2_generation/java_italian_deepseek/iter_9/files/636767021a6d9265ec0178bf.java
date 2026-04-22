import java.util.Objects;

/**
 * Converte l'oggetto di input in un java.lang.Character.
 * @param type Il tipo di dato in cui questo valore dovrebbe essere convertito.
 * @param value Il valore di input da convertire.
 * @return Il valore convertito.
 * @throws Exception se la conversione non può essere eseguita con successo
 * @since 1.8.0
 */
@Override
protected Object convertToType(final Class<?> type, final Object value) throws Exception {
    if (type != Character.class && type != char.class) {
        throw new Exception("Il tipo di destinazione non è un Character o char.");
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
            throw new Exception("Il valore numerico non può essere convertito in un carattere valido.");
        }
    }

    if (value instanceof String) {
        String strValue = (String) value;
        if (strValue.length() == 1) {
            return strValue.charAt(0);
        } else {
            throw new Exception("La stringa deve contenere esattamente un carattere.");
        }
    }

    throw new Exception("Impossibile convertire il valore in un Character.");
}