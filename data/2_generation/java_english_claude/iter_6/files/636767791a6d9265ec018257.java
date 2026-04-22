import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class Logger {
    private LogTable logTable; // Assume LogTable is a custom JTable component

    public Logger(LogTable logTable) {
        this.logTable = logTable;
    }

    /**
     * Add a log record message to be displayed in the LogTable. This method is thread-safe 
     * as it posts requests to the SwingThread rather than processing directly.
     */
    public void addMessage(final LogRecord lr) {
        if (lr == null) {
            return;
        }

        // Ensure thread safety by running on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Add the log record to the table model
                logTable.getModel().addRow(new Object[]{
                    lr.getMillis(),
                    lr.getLevel(),
                    lr.getMessage(),
                    lr.getSourceClassName(),
                    lr.getSourceMethodName(),
                    lr.getThrown()
                });

                // Auto scroll to the bottom
                int lastRow = logTable.getModel().getRowCount() - 1;
                if (lastRow >= 0) {
                    logTable.scrollRectToVisible(
                        logTable.getCellRect(lastRow, 0, true)
                    );
                }
            }
        });
    }
}