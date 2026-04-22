import java.time.Instant;

public class FileOperations {
    private long lastWriteTimestamp;

    public FileOperations() {
        this.lastWriteTimestamp = Instant.now().toEpochMilli();
    }

    /**
     * La última vez, en milisegundos, que ocurrió una operación de escritura.
     * @return esto
     */
    public long lastWriteTimeStampInMilliseconds() {
        return this.lastWriteTimestamp;
    }
}