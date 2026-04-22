import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private List<List<Double>> matrix;
    
    /**
     * 获取一行中非零条目的数量。
     * @param row 行号
     * @return 一行中非零条目的数量
     */
    public int nonZeros(int row) {
        if (row < 0 || row >= matrix.size()) {
            throw new IllegalArgumentException("Invalid row index");
        }
        
        int count = 0;
        List<Double> rowList = matrix.get(row);
        
        for (Double element : rowList) {
            if (element != null && element != 0.0) {
                count++;
            }
        }
        
        return count;
    }
}