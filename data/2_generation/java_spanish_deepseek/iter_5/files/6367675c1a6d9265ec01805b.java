// Asumiendo que la clase que contiene este método tiene referencias a las listas doblemente enlazadas de bordes.
// También asumimos que la clase tiene un campo `this` que representa el borde actual.

public void removeFromTreeEdgeList() {
    // Verificar si el borde tiene un nodo anterior en la lista
    if (this.previous != null) {
        this.previous.next = this.next;
    }

    // Verificar si el borde tiene un nodo siguiente en la lista
    if (this.next != null) {
        this.next.previous = this.previous;
    }

    // Si el borde es el primer nodo de la lista, actualizar la cabeza de la lista
    if (this == treeEdgeListHead) {
        treeEdgeListHead = this.next;
    }

    // Si el borde es el último nodo de la lista, actualizar la cola de la lista
    if (this == treeEdgeListTail) {
        treeEdgeListTail = this.previous;
    }

    // Limpiar las referencias del borde actual para evitar referencias colgantes
    this.previous = null;
    this.next = null;
}