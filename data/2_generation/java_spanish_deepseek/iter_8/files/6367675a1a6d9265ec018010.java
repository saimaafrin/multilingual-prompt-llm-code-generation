import java.util.*;

class Bucket {
    // Asumiendo que el bucket es parte de una estructura de datos como una lista o un conjunto
    private List<Bucket> bucketList; // Ejemplo de estructura de datos que contiene los buckets

    public Bucket(List<Bucket> bucketList) {
        this.bucketList = bucketList;
    }

    /**
     * Elimina este bucket de la estructura de datos.
     */
    void removeSelf() {
        if (bucketList != null) {
            bucketList.remove(this);
        }
    }
}