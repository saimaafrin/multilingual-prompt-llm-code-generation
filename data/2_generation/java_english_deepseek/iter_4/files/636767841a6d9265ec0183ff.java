import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableUtils {

    /**
     * Selects the specified row in the specified JTable and scrolls the specified JScrollPane to the newly selected row.
     * More importantly, the call to repaint() is delayed long enough to have the table properly paint the newly selected row which may be offscreen.
     * @param row The row index to select.
     * @param table The JTable to select the row in. Should belong to the specified JScrollPane.
     * @param pane The JScrollPane containing the JTable.
     */
    public static void selectRow(int row, JTable table, JScrollPane pane) {
        if (row >= 0 && row < table.getRowCount()) {
            table.setRowSelectionInterval(row, row);
            table.scrollRectToVisible(table.getCellRect(row, 0, true));

            // Delay the repaint to ensure the table properly paints the newly selected row
            SwingUtilities.invokeLater(() -> {
                table.repaint();
                pane.repaint();
            });
        }
    }

    public static void main(String[] args) {
        // Example usage
        JFrame frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Column 1", "Column 2"}, 0);
        for (int i = 0; i < 50; i++) {
            model.addRow(new Object[]{"Row " + i, "Data " + i});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

        // Select row 25 after a delay to demonstrate the method
        Timer timer = new Timer(2000, e -> selectRow(25, table, scrollPane));
        timer.setRepeats(false);
        timer.start();
    }
}