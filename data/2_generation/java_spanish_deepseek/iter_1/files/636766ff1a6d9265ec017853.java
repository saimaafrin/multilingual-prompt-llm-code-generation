import org.objectweb.asm.Label;

/**
 * Devuelve la etiqueta correspondiente al "offset" del bytecode dado. La implementación predeterminada de este método crea una etiqueta para el desplazamiento dado si aún no se ha creado.
 * @param bytecodeOffset un "offset" de bytecode en un método.
 * @param labels las etiquetas ya creadas, indexadas por su "offset". Si ya existe una etiqueta para bytecodeOffset, este método no debe crear una nueva. De lo contrario, debe almacenar la nueva etiqueta en este arreglo.
 * @return una etiqueta no nula, que debe ser igual a labels[bytecodeOffset].
 */
protected Label readLabel(final int bytecodeOffset, final Label[] labels) {
    if (labels[bytecodeOffset] == null) {
        labels[bytecodeOffset] = new Label();
    }
    return labels[bytecodeOffset];
}