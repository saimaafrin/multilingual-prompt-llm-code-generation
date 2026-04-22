public class ArrayDetailAppender {

    /** 
     * <p>Agrega al <code>toString</code> el detalle de un array de <code>byte</code>.</p>
     * @param buffer  el <code>StringBuffer</code> a poblar
     * @param fieldName  el nombre del campo, típicamente no se utiliza ya que ya ha sido agregado
     * @param array  el array que se añadirá al <code>toString</code>, no <code>null</code>
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
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
        byte[] byteArray = {1, 2, 3, 4, 5};
        appender.appendDetail(buffer, "byteArray", byteArray);
        System.out.println(buffer.toString());
    }
}