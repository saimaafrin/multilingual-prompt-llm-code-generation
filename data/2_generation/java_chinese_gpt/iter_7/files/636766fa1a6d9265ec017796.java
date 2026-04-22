public class BooleanArrayConverter {
    
    /** 
     * <p>将基本数据类型的 boolean 数组转换为对象。</p> <p>对于输入数组 <code>null</code>，此方法返回 <code>null</code>。</p>
     * @param array  一个 <code>boolean</code> 数组
     * @return 一个 <code>Boolean</code> 数组，如果输入数组为空则返回 <code>null</code>
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        }
        
        Boolean[] objectArray = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = Boolean.valueOf(array[i]);
        }
        return objectArray;
    }

    public static void main(String[] args) {
        boolean[] primitiveArray = {true, false, true};
        Boolean[] objectArray = toObject(primitiveArray);
        
        for (Boolean b : objectArray) {
            System.out.println(b);
        }
    }
}