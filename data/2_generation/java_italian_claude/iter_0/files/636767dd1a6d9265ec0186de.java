public class CacheMetrics {
    /**
     * @param timestamp        tempo attuale
     * @param expiredThreshold rappresenta la durata tra l'ultimo aggiornamento e il momento in cui si rimuove dalla cache.
     * @return true significa che queste metriche devono essere rimosse dalla cache.
     */
    public boolean isExpired(long timestamp, long expiredThreshold) {
        long lastUpdateTime = System.currentTimeMillis(); // Get current time in milliseconds
        long timeDifference = timestamp - lastUpdateTime;
        
        return timeDifference >= expiredThreshold;
    }
}