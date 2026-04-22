import javax.swing.*;
import java.util.logging.LogRecord;

public class LogTable {
    private final JTable logTable;
    private final DefaultTableModel tableModel;

    public LogTable(JTable logTable, DefaultTableModel tableModel) {
        this.logTable = logTable;
        this.tableModel = tableModel;
    }

    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(() -> {
            Object[] rowData = {lr.getLevel(), lr.getMessage(), lr.getMillis()};
            tableModel.addRow(rowData);
            logTable.scrollRectToVisible(logTable.getCellRect(tableModel.getRowCount() - 1, 0, true));
        });
    }
}