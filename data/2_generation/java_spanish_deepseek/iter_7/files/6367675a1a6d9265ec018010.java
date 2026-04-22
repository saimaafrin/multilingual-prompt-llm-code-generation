import java.util.*;

class Bucket {
    private String name;
    private List<Bucket> buckets;

    public Bucket(String name) {
        this.name = name;
        this.buckets = new ArrayList<>();
    }

    public void addBucket(Bucket bucket) {
        buckets.add(bucket);
    }

    public void removeSelf() {
        // Elimina este bucket de la estructura de datos
        // Aquí asumimos que el bucket es eliminado de una lista de buckets en un contexto más amplio
        // Por ejemplo, si este bucket es parte de una lista en una clase contenedora, se eliminaría de allí.
        // Este método no tiene implementación específica ya que depende del contexto en el que se use.
        // En un caso real, se podría eliminar de una lista o estructura de datos que lo contenga.
        System.out.println("Bucket " + name + " has been removed.");
    }

    public static void main(String[] args) {
        Bucket bucket1 = new Bucket("Bucket1");
        Bucket bucket2 = new Bucket("Bucket2");

        bucket1.addBucket(bucket2);
        bucket1.removeSelf();
    }
}