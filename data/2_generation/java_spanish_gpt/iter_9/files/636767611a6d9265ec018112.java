@Override
protected V proporcionarSiguienteVertice() {
    // Implementación del método para proporcionar el siguiente vértice
    // Aquí se puede agregar la lógica específica para determinar el siguiente vértice
    // Por ejemplo, si se está utilizando una lista de vértices:
    
    if (vertices.isEmpty()) {
        return null; // O lanzar una excepción si no hay vértices disponibles
    }
    
    // Suponiendo que 'indice' es un campo que mantiene el índice del siguiente vértice a devolver
    V siguienteVertice = vertices.get(indice);
    indice = (indice + 1) % vertices.size(); // Actualiza el índice para el siguiente llamado
    return siguienteVertice;
}