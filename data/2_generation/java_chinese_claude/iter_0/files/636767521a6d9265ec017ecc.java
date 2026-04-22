import javafx.util.Pair;

public class BoxSplitter {
    
    public static class Box2D {
        private double x;
        private double y;
        private double width; 
        private double height;
        
        public Box2D(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        
        public double getX() { return x; }
        public double getY() { return y; }
        public double getWidth() { return width; }
        public double getHeight() { return height; }
    }

    /** 
     * 沿 x 轴将一个矩形框拆分为两个相等的矩形框。
     * @param box 要拆分的矩形框
     * @return 包含两个拆分后矩形框的对
     */
    public static Pair<Box2D, Box2D> splitAlongXAxis(Box2D box) {
        // 计算每个新矩形框的高度
        double newHeight = box.getHeight() / 2;
        
        // 创建上半部分的矩形框
        Box2D topBox = new Box2D(
            box.getX(),
            box.getY(),
            box.getWidth(),
            newHeight
        );
        
        // 创建下半部分的矩形框
        Box2D bottomBox = new Box2D(
            box.getX(),
            box.getY() + newHeight,
            box.getWidth(),
            newHeight
        );
        
        return new Pair<>(topBox, bottomBox);
    }
}