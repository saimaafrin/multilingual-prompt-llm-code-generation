public class NameAbbreviator {

    /**
     * Abrevia un nombre en el buffer dado, comenzando desde el índice especificado.
     * @param nameStart inicio del nombre a abreviar.
     * @param buf buffer para agregar la abreviatura.
     */
    public void abbreviate(final int nameStart, final StringBuffer buf) {
        if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
            return; // No se puede abreviar si el buffer es nulo o el índice es inválido.
        }

        // Encuentra el primer espacio después de nameStart
        int spaceIndex = buf.indexOf(" ", nameStart);
        if (spaceIndex == -1) {
            return; // No hay espacio para abreviar.
        }

        // Reemplaza el nombre completo con la primera letra y un punto
        buf.replace(nameStart, spaceIndex, buf.substring(nameStart, nameStart + 1) + ".");
    }

    public static void main(String[] args) {
        NameAbbreviator abbreviator = new NameAbbreviator();
        StringBuffer buf = new StringBuffer("John Doe");
        abbreviator.abbreviate(0, buf);
        System.out.println(buf); // Debería imprimir "J. Doe"
    }
}