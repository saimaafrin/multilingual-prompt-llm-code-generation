import java.util.Arrays;

/**
 * <p>Agrega al <code>toString</code> el detalle de un array de <code>byte</code>.</p>
 * @param buffer  el <code>StringBuffer</code> a poblar
 * @param fieldName  el nombre del campo, típicamente no se utiliza ya que ya ha sido agregado
 * @param array  el array que se añadirá al <code>toString</code>, no <code>null</code>
 */
protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
    if (array == null) {
        throw new IllegalArgumentException("El array no puede ser null");
    }
    buffer.append(Arrays.toString(array));
}