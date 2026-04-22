@Override
protected V proporcionarSiguienteVertice() {
    // Implementación del método para proporcionar el siguiente vértice
    // Aquí se debe incluir la lógica específica para determinar el siguiente vértice
    // Por ejemplo, se puede utilizar una lista o un conjunto de vértices y devolver el siguiente en la secuencia

    // Suponiendo que hay una lista de vértices llamada 'vertices' y un índice 'indiceActual'
    if (indiceActual < vertices.size() - 1) {
        indiceActual++;
        return vertices.get(indiceActual);
    } else {
        // Si no hay más vértices, se puede devolver null o lanzar una excepción
        return null; // o lanzar una excepción según sea necesario
    }
}