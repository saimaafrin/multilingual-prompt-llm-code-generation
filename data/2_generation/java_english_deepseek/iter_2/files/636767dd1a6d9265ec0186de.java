/**
 * Determines if a given timestamp has expired based on a threshold.
 * 
 * @param timestamp        The current time in milliseconds since epoch.
 * @param expiredThreshold The duration in milliseconds after which the timestamp is considered expired.
 * @return true if the timestamp has expired, false otherwise.
 */
public boolean isExpired(long timestamp, long expiredThreshold) {
    long currentTime = System.currentTimeMillis();
    return (currentTime - timestamp) > expiredThreshold;
}