public class CharUtils {
    /** 
     * <p>Verifica si el carácter es un control ASCII de 7 bits.</p> 
     * <pre> 
     * CharUtils.isAsciiControl('a')  = false 
     * CharUtils.isAsciiControl('A')  = false 
     * CharUtils.isAsciiControl('3')  = false 
     * CharUtils.isAsciiControl('-')  = false 
     * CharUtils.isAsciiControl('\n') = true 
     * CharUtils.isAsciiControl('&copy;') = false 
     * </pre>
     * @param ch  el carácter a verificar
     * @return true si es menor que 32 o igual a 127
     */
    public static boolean isAsciiControl(final char ch) {
        return ch < 32 || ch == 127;
    }

    public static void main(String[] args) {
        System.out.println(isAsciiControl('a'));  // false
        System.out.println(isAsciiControl('A'));  // false
        System.out.println(isAsciiControl('3'));  // false
        System.out.println(isAsciiControl('-'));  // false
        System.out.println(isAsciiControl('\n')); // true
        System.out.println(isAsciiControl('\u00A9')); // false
    }
}