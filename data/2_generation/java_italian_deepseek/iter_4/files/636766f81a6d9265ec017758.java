@Override
public int hashCode() {
    // Implementazione di un semplice hash code basato su un valore fisso
    // Questo è un esempio di base, in un caso reale dovresti considerare
    // le proprietà dell'oggetto per calcolare un hash code più significativo.
    final int prime = 31;
    int result = 1;
    // Supponiamo che questo oggetto abbia un campo 'id' che contribuisce all'hash code
    // result = prime * result + (id == null ? 0 : id.hashCode());
    return result;
}