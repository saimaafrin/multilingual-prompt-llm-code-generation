import java.util.HashMap;
import java.util.Map;

public class ConstantPool {
    private final Map<String, Integer> nameAndTypeMap;
    private int nextIndex;

    public ConstantPool() {
        this.nameAndTypeMap = new HashMap<>();
        this.nextIndex = 0;
    }

    /**
     * Agrega una entrada CONSTANT_NameAndType_info de un grupo de constantes de esta tabla de símbolos. 
     * No hace nada si el grupo de constantes ya contiene un elemento similar.
     *
     * @param name el nombre de un campo o método.
     * @param descriptor un descriptor de campo o método.
     * @return un nuevo símbolo o uno ya existente con el valor dado.
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (!nameAndTypeMap.containsKey(key)) {
            nameAndTypeMap.put(key, nextIndex);
            nextIndex++;
        }
        return nameAndTypeMap.get(key);
    }

    public static void main(String[] args) {
        ConstantPool constantPool = new ConstantPool();
        int index1 = constantPool.addConstantNameAndType("myField", "I");
        int index2 = constantPool.addConstantNameAndType("myField", "I");
        System.out.println("Index of myField: " + index1);
        System.out.println("Index of myField (duplicate): " + index2);
    }
}