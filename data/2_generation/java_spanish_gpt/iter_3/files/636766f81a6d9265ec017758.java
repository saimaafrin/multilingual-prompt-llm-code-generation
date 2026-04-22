@Override
public int hashCode() {
    // Implementación del código hash
    int result = 17; // Valor inicial
    // Supongamos que tenemos dos atributos: 'field1' y 'field2'
    result = 31 * result + (field1 != null ? field1.hashCode() : 0);
    result = 31 * result + (field2 != null ? field2.hashCode() : 0);
    return result;
}