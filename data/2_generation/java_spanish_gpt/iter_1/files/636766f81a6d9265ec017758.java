@Override
public int hashCode() {
    // Implementación de un código hash simple basado en un campo de ejemplo
    int result = 17; // Número primo inicial
    result = 31 * result + (field1 != null ? field1.hashCode() : 0);
    result = 31 * result + field2; // Suponiendo que field2 es un int
    // Agregar más campos según sea necesario
    return result;
}