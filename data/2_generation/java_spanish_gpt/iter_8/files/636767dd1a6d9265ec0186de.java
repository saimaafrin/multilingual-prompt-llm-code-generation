public class CacheExpiration {

    /** 
     * @param timestamp        del tiempo actual
     * @param expiredThreshold representa la duración entre el último tiempo de actualización y el punto en el tiempo que se eliminará de la caché.
     * @return true significa que esta métrica debe ser eliminada de la caché.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) > expiredThreshold;
    }

    public static void main(String[] args) {
        CacheExpiration cacheExpiration = new CacheExpiration();
        long timestamp = System.currentTimeMillis() - 5000; // 5 seconds ago
        long expiredThreshold = 3000; // 3 seconds

        boolean result = cacheExpiration.isExpired(timestamp, expiredThreshold);
        System.out.println("Is expired: " + result); // Should print true
    }
}