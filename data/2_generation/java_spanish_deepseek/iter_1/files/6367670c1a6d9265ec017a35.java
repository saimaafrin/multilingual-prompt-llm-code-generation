/**
 * Verifica si una cadena termina con un sufijo especificado (opcionalmente sin distinguir entre mayúsculas y minúsculas).
 * @see String#endsWith(String)
 * @param str  la cadena a verificar, puede ser nula
 * @param suffix el sufijo a encontrar, puede ser nulo
 * @param ignoreCase indica si la comparación debe ignorar las mayúsculas y minúsculas (sin distinguir entre mayúsculas y minúsculas) o no.
 * @return <code>true</code> si la cadena termina con el sufijo o ambos son <code>null</code>
 */
private static boolean endsWith(final String str, final String suffix, final boolean ignoreCase) {
    if (str == null && suffix == null) {
        return true;
    }
    if (str == null || suffix == null) {
        return false;
    }
    if (ignoreCase) {
        return str.toLowerCase().endsWith(suffix.toLowerCase());
    } else {
        return str.endsWith(suffix);
    }
}