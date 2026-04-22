public class StringArrayUtil {
    
    /** 
     * Agrega la cadena dada al arreglo de cadenas proporcionado, devolviendo un nuevo arreglo que consiste en el contenido del arreglo de entrada más la cadena dada.
     * @param array el arreglo al que se va a agregar (puede ser <code>null</code>)
     * @param str la cadena a agregar
     * @return el nuevo arreglo (nunca <code>null</code>)
     */
    public static String[] addStringToArray(String[] array, String str) {
        // Si el arreglo es nulo, inicializarlo como un arreglo vacío
        if (array == null) {
            array = new String[0];
        }
        
        // Crear un nuevo arreglo con un tamaño mayor en 1
        String[] newArray = new String[array.length + 1];
        
        // Copiar los elementos del arreglo original al nuevo arreglo
        System.arraycopy(array, 0, newArray, 0, array.length);
        
        // Agregar la nueva cadena al final del nuevo arreglo
        newArray[array.length] = str;
        
        return newArray;
    }
    
    public static void main(String[] args) {
        String[] originalArray = {"Hello", "World"};
        String newString = "!";
        String[] updatedArray = addStringToArray(originalArray, newString);
        
        // Imprimir el nuevo arreglo
        for (String s : updatedArray) {
            System.out.print(s + " ");
        }
    }
}