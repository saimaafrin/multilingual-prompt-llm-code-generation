@Override
public int hashCode() {
    // Implementazione di base di hashCode
    // Questo è un esempio semplice, potrebbe non essere adatto per tutti i casi
    // In un'implementazione reale, dovresti considerare tutti i campi rilevanti
    // che contribuiscono all'uguaglianza dell'oggetto.
    final int prime = 31;
    int result = 1;
    // Supponiamo che ci siano due campi: field1 e field2
    // result = prime * result + (field1 == null ? 0 : field1.hashCode());
    // result = prime * result + (field2 == null ? 0 : field2.hashCode());
    return result;
}