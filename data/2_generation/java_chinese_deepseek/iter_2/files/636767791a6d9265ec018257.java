import javax.swing.*;
import java.util.logging.LogRecord;

public class LogTable {
    private final JTable table;

    public LogTable(JTable table) {
        this.table = table;
    }

    public void addMessage(final LogRecord lr) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Assuming the table model is a DefaultTableModel
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{lr.getLevel(), lr.getMessage()});
            }
        });
    }
}