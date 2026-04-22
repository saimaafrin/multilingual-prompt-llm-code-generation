public class ClassFinder {
    
    /** 
     * 根据类名查找类。
     * @param className 类名，不能为空。
     * @return 类，不会空。
     * @throws ClassNotFoundException 如果找不到类则抛出此异常。
     */
    private Class<?> findClass(final String className) throws ClassNotFoundException {
        if (className == null || className.isEmpty()) {
            throw new IllegalArgumentException("类名不能为空");
        }
        return Class.forName(className);
    }

    public static void main(String[] args) {
        ClassFinder finder = new ClassFinder();
        try {
            Class<?> clazz = finder.findClass("java.lang.String");
            System.out.println("找到的类: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}