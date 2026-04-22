import javax.swing.SwingUtilities;
import java.util.logging.LogRecord;

public class LogTable {
    private final List<LogRecord> logRecords;
    private final DefaultTableModel tableModel;
    
    public LogTable() {
        logRecords = new ArrayList<>();
        tableModel = new DefaultTableModel();
        // Initialize table columns
        tableModel.addColumn("Time");
        tableModel.addColumn("Level"); 
        tableModel.addColumn("Message");
    }

    /**
     * 添加日志记录消息以显示在 LogTable 中。此方法是线程安全的，因为它将请求发送到 SwingThread，而不是直接处理。
     */
    public void addMessage(final LogRecord lr) {
        if (lr == null) {
            return;
        }
        
        // Ensure thread safety by running on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                logRecords.add(lr);
                
                // Add new row to table model
                Object[] rowData = new Object[3];
                rowData[0] = new java.util.Date(lr.getMillis());
                rowData[1] = lr.getLevel();
                rowData[2] = lr.getMessage();
                
                tableModel.addRow(rowData);
                
                // Auto scroll to bottom
                int lastRow = tableModel.getRowCount() - 1;
                if (lastRow >= 0) {
                    scrollRectToVisible(getCellRect(lastRow, 0, true));
                }
            }
        });
    }
}