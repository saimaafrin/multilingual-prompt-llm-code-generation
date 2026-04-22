public class ArrayDetailAppender {

    /**
     * <p>Agrega al <code>toString</code> el detalle de un arreglo de <code>int</code>.</p>
     * @param buffer  el <code>StringBuffer</code> a poblar
     * @param fieldName  el nombre del campo, típicamente no se utiliza ya que ya ha sido agregado
     * @param array  el arreglo que se añadirá al <code>toString</code>, no <code>null</code>
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        buffer.append(fieldName).append(": [");
        for (int i = 0; i < array.length; i++) {
            buffer.append(array[i]);
            if (i < array.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
    }

    public static void main(String[] args) {
        ArrayDetailAppender appender = new ArrayDetailAppender();
        StringBuffer buffer = new StringBuffer();
        int[] array = {1, 2, 3, 4, 5};
        appender.appendDetail(buffer, "myArray", array);
        System.out.println(buffer.toString());
    }
}