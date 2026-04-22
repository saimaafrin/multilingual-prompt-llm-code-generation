import java.util.Arrays;

/**
 * <p>Agrega al <code>toString</code> el detalle de un arreglo de <code>int</code>.</p>
 * @param buffer  el <code>StringBuffer</code> a poblar
 * @param fieldName  el nombre del campo, típicamente no se utiliza ya que ya ha sido agregado
 * @param array  el arreglo que se añadirá al <code>toString</code>, no <code>null</code>
 */
protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
    if (array == null) {
        throw new IllegalArgumentException("El arreglo no puede ser null");
    }
    buffer.append(Arrays.toString(array));
}