import java.util.Arrays;

public class ToStringBuilder {

    /**
     * <p>Agrega al <code>toString</code> el detalle de un arreglo de <code>int</code>.</p>
     * @param buffer  el <code>StringBuffer</code> a poblar
     * @param fieldName  el nombre del campo, típicamente no se utiliza ya que ya ha sido agregado
     * @param array  el arreglo que se añadirá al <code>toString</code>, no <code>null</code>
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
        buffer.append('[');
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(',');
            }
            buffer.append(array[i]);
        }
        buffer.append(']');
    }
}